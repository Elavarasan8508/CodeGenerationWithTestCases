package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class FgActRuBatch {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String type_;

    private java.math.BigDecimal totalJobs_;

    private java.math.BigDecimal jobsCreated_;

    private java.math.BigDecimal jobsPerSeed_;

    private java.math.BigDecimal invocationsPerJob_;

    private String seedJobDefID_;

    private String batchJobDefID_;

    private String monitorJobDefID_;

    private java.math.BigDecimal suspensionState_;

    private String configuration_;

    private String tenantID_;

    private String createUserID_;

    private List<FgActRuVariable> fgActRuVariableList;

    public FgActRuBatch() {
    }

    public FgActRuBatch(String ID_, java.math.BigDecimal rev_, String type_, java.math.BigDecimal totalJobs_, java.math.BigDecimal jobsCreated_, java.math.BigDecimal jobsPerSeed_, java.math.BigDecimal invocationsPerJob_, String seedJobDefID_, String batchJobDefID_, String monitorJobDefID_, java.math.BigDecimal suspensionState_, String configuration_, String tenantID_, String createUserID_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.type_ = type_;
        this.totalJobs_ = totalJobs_;
        this.jobsCreated_ = jobsCreated_;
        this.jobsPerSeed_ = jobsPerSeed_;
        this.invocationsPerJob_ = invocationsPerJob_;
        this.seedJobDefID_ = seedJobDefID_;
        this.batchJobDefID_ = batchJobDefID_;
        this.monitorJobDefID_ = monitorJobDefID_;
        this.suspensionState_ = suspensionState_;
        this.configuration_ = configuration_;
        this.tenantID_ = tenantID_;
        this.createUserID_ = createUserID_;
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

    public java.math.BigDecimal getTotalJobs_() {
        return totalJobs_;
    }

    public void setTotalJobs_(java.math.BigDecimal totalJobs_) {
        this.totalJobs_ = totalJobs_;
    }

    public java.math.BigDecimal getJobsCreated_() {
        return jobsCreated_;
    }

    public void setJobsCreated_(java.math.BigDecimal jobsCreated_) {
        this.jobsCreated_ = jobsCreated_;
    }

    public java.math.BigDecimal getJobsPerSeed_() {
        return jobsPerSeed_;
    }

    public void setJobsPerSeed_(java.math.BigDecimal jobsPerSeed_) {
        this.jobsPerSeed_ = jobsPerSeed_;
    }

    public java.math.BigDecimal getInvocationsPerJob_() {
        return invocationsPerJob_;
    }

    public void setInvocationsPerJob_(java.math.BigDecimal invocationsPerJob_) {
        this.invocationsPerJob_ = invocationsPerJob_;
    }

    public String getSeedJobDefID_() {
        return seedJobDefID_;
    }

    public void setSeedJobDefID_(String seedJobDefID_) {
        this.seedJobDefID_ = seedJobDefID_;
    }

    public String getBatchJobDefID_() {
        return batchJobDefID_;
    }

    public void setBatchJobDefID_(String batchJobDefID_) {
        this.batchJobDefID_ = batchJobDefID_;
    }

    public String getMonitorJobDefID_() {
        return monitorJobDefID_;
    }

    public void setMonitorJobDefID_(String monitorJobDefID_) {
        this.monitorJobDefID_ = monitorJobDefID_;
    }

    public java.math.BigDecimal getSuspensionState_() {
        return suspensionState_;
    }

    public void setSuspensionState_(java.math.BigDecimal suspensionState_) {
        this.suspensionState_ = suspensionState_;
    }

    public String getConfiguration_() {
        return configuration_;
    }

    public void setConfiguration_(String configuration_) {
        this.configuration_ = configuration_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public String getCreateUserID_() {
        return createUserID_;
    }

    public void setCreateUserID_(String createUserID_) {
        this.createUserID_ = createUserID_;
    }

    public List<FgActRuVariable> getFgActRuVariableList() {
        return fgActRuVariableList;
    }

    public void setFgActRuVariableList(List<FgActRuVariable> fgActRuVariableList) {
        this.fgActRuVariableList = fgActRuVariableList;
    }

    public static class Builder {

        private FgActRuBatch instance = new FgActRuBatch();

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

        public Builder totalJobs_(java.math.BigDecimal totalJobs_) {
            instance.setTotalJobs_(totalJobs_);
            return this;
        }

        public Builder jobsCreated_(java.math.BigDecimal jobsCreated_) {
            instance.setJobsCreated_(jobsCreated_);
            return this;
        }

        public Builder jobsPerSeed_(java.math.BigDecimal jobsPerSeed_) {
            instance.setJobsPerSeed_(jobsPerSeed_);
            return this;
        }

        public Builder invocationsPerJob_(java.math.BigDecimal invocationsPerJob_) {
            instance.setInvocationsPerJob_(invocationsPerJob_);
            return this;
        }

        public Builder seedJobDefID_(String seedJobDefID_) {
            instance.setSeedJobDefID_(seedJobDefID_);
            return this;
        }

        public Builder batchJobDefID_(String batchJobDefID_) {
            instance.setBatchJobDefID_(batchJobDefID_);
            return this;
        }

        public Builder monitorJobDefID_(String monitorJobDefID_) {
            instance.setMonitorJobDefID_(monitorJobDefID_);
            return this;
        }

        public Builder suspensionState_(java.math.BigDecimal suspensionState_) {
            instance.setSuspensionState_(suspensionState_);
            return this;
        }

        public Builder configuration_(String configuration_) {
            instance.setConfiguration_(configuration_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public Builder createUserID_(String createUserID_) {
            instance.setCreateUserID_(createUserID_);
            return this;
        }

        public Builder fgActRuVariableList(List<FgActRuVariable> fgActRuVariableList) {
            instance.setFgActRuVariableList(fgActRuVariableList);
            return this;
        }

        public FgActRuBatch build() {
            return instance;
        }
    }
}
