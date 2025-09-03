package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActHiBatch {

    private String ID_;

    private String type_;

    private java.math.BigDecimal totalJobs_;

    private java.math.BigDecimal jobsPerSeed_;

    private java.math.BigDecimal invocationsPerJob_;

    private String seedJobDefID_;

    private String monitorJobDefID_;

    private String batchJobDefID_;

    private String tenantID_;

    private String startTime_;

    private String endTime_;

    private String createUserID_;

    private String removalTime_;

    public FgActHiBatch() {
    }

    public FgActHiBatch(String ID_, String type_, java.math.BigDecimal totalJobs_, java.math.BigDecimal jobsPerSeed_, java.math.BigDecimal invocationsPerJob_, String seedJobDefID_, String monitorJobDefID_, String batchJobDefID_, String tenantID_, String startTime_, String endTime_, String createUserID_, String removalTime_) {
        this.ID_ = ID_;
        this.type_ = type_;
        this.totalJobs_ = totalJobs_;
        this.jobsPerSeed_ = jobsPerSeed_;
        this.invocationsPerJob_ = invocationsPerJob_;
        this.seedJobDefID_ = seedJobDefID_;
        this.monitorJobDefID_ = monitorJobDefID_;
        this.batchJobDefID_ = batchJobDefID_;
        this.tenantID_ = tenantID_;
        this.startTime_ = startTime_;
        this.endTime_ = endTime_;
        this.createUserID_ = createUserID_;
        this.removalTime_ = removalTime_;
    }

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
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

    public String getMonitorJobDefID_() {
        return monitorJobDefID_;
    }

    public void setMonitorJobDefID_(String monitorJobDefID_) {
        this.monitorJobDefID_ = monitorJobDefID_;
    }

    public String getBatchJobDefID_() {
        return batchJobDefID_;
    }

    public void setBatchJobDefID_(String batchJobDefID_) {
        this.batchJobDefID_ = batchJobDefID_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
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

    public String getCreateUserID_() {
        return createUserID_;
    }

    public void setCreateUserID_(String createUserID_) {
        this.createUserID_ = createUserID_;
    }

    public String getRemovalTime_() {
        return removalTime_;
    }

    public void setRemovalTime_(String removalTime_) {
        this.removalTime_ = removalTime_;
    }

    public static class Builder {

        private FgActHiBatch instance = new FgActHiBatch();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
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

        public Builder monitorJobDefID_(String monitorJobDefID_) {
            instance.setMonitorJobDefID_(monitorJobDefID_);
            return this;
        }

        public Builder batchJobDefID_(String batchJobDefID_) {
            instance.setBatchJobDefID_(batchJobDefID_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
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

        public Builder createUserID_(String createUserID_) {
            instance.setCreateUserID_(createUserID_);
            return this;
        }

        public Builder removalTime_(String removalTime_) {
            instance.setRemovalTime_(removalTime_);
            return this;
        }

        public FgActHiBatch build() {
            return instance;
        }
    }
}
