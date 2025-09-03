package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class BatchJobInstance {

    private Integer jobInstanceID;

    private java.math.BigDecimal version;

    private String jobName;

    private String jobKey;

    private List<BatchJobExecution> batchJobExecutionList;

    public BatchJobInstance() {
    }

    public BatchJobInstance(Integer jobInstanceID, java.math.BigDecimal version, String jobName, String jobKey) {
        this.jobInstanceID = jobInstanceID;
        this.version = version;
        this.jobName = jobName;
        this.jobKey = jobKey;
    }

    public Integer getJobInstanceID() {
        return jobInstanceID;
    }

    public void setJobInstanceID(Integer jobInstanceID) {
        this.jobInstanceID = jobInstanceID;
    }

    public java.math.BigDecimal getVersion() {
        return version;
    }

    public void setVersion(java.math.BigDecimal version) {
        this.version = version;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobKey() {
        return jobKey;
    }

    public void setJobKey(String jobKey) {
        this.jobKey = jobKey;
    }

    public List<BatchJobExecution> getBatchJobExecutionList() {
        return batchJobExecutionList;
    }

    public void setBatchJobExecutionList(List<BatchJobExecution> batchJobExecutionList) {
        this.batchJobExecutionList = batchJobExecutionList;
    }

    public static class Builder {

        private BatchJobInstance instance = new BatchJobInstance();

        public Builder jobInstanceID(Integer jobInstanceID) {
            instance.setJobInstanceID(jobInstanceID);
            return this;
        }

        public Builder version(java.math.BigDecimal version) {
            instance.setVersion(version);
            return this;
        }

        public Builder jobName(String jobName) {
            instance.setJobName(jobName);
            return this;
        }

        public Builder jobKey(String jobKey) {
            instance.setJobKey(jobKey);
            return this;
        }

        public Builder batchJobExecutionList(List<BatchJobExecution> batchJobExecutionList) {
            instance.setBatchJobExecutionList(batchJobExecutionList);
            return this;
        }

        public BatchJobInstance build() {
            return instance;
        }
    }
}
