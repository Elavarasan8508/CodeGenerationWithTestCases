package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class BatchJobExecution {

    private Integer jobExecutionID;

    private java.math.BigDecimal version;

    private Integer jobInstanceID;

    private String createTime;

    private String startTime;

    private String endTime;

    private String status;

    private String exitCode;

    private String exitMessage;

    private String lastUpdated;

    private String jobConfigurationLocation;

    private BatchJobInstance jobInstance;

    private BatchJobExecutionContext jobExecution;

    private BatchStepExecutionContext stepExecution;

    private List<BatchJobExecutionContext> batchJobExecutionContextList;

    private List<BatchJobExecutionParams> batchJobExecutionParamsList;

    private List<BatchStepExecution> batchStepExecutionList;

    public BatchJobExecution() {
    }

    public BatchJobExecution(Integer jobExecutionID, java.math.BigDecimal version, Integer jobInstanceID, String createTime, String startTime, String endTime, String status, String exitCode, String exitMessage, String lastUpdated, String jobConfigurationLocation, BatchJobInstance jobInstance, BatchJobExecutionContext jobExecution, BatchStepExecutionContext stepExecution) {
        this.jobExecutionID = jobExecutionID;
        this.version = version;
        this.jobInstanceID = jobInstanceID;
        this.createTime = createTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.exitCode = exitCode;
        this.exitMessage = exitMessage;
        this.lastUpdated = lastUpdated;
        this.jobConfigurationLocation = jobConfigurationLocation;
        this.jobInstance = jobInstance;
        this.jobExecution = jobExecution;
        this.stepExecution = stepExecution;
    }

    public Integer getJobExecutionID() {
        return jobExecutionID;
    }

    public void setJobExecutionID(Integer jobExecutionID) {
        this.jobExecutionID = jobExecutionID;
    }

    public java.math.BigDecimal getVersion() {
        return version;
    }

    public void setVersion(java.math.BigDecimal version) {
        this.version = version;
    }

    public Integer getJobInstanceID() {
        return jobInstanceID;
    }

    public void setJobInstanceID(Integer jobInstanceID) {
        this.jobInstanceID = jobInstanceID;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExitCode() {
        return exitCode;
    }

    public void setExitCode(String exitCode) {
        this.exitCode = exitCode;
    }

    public String getExitMessage() {
        return exitMessage;
    }

    public void setExitMessage(String exitMessage) {
        this.exitMessage = exitMessage;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getJobConfigurationLocation() {
        return jobConfigurationLocation;
    }

    public void setJobConfigurationLocation(String jobConfigurationLocation) {
        this.jobConfigurationLocation = jobConfigurationLocation;
    }

    public BatchJobInstance getJobInstance() {
        return jobInstance;
    }

    public void setJobInstance(BatchJobInstance jobInstance) {
        this.jobInstance = jobInstance;
    }

    public BatchJobExecutionContext getJobExecution() {
        return jobExecution;
    }

    public void setJobExecution(BatchJobExecutionContext jobExecution) {
        this.jobExecution = jobExecution;
    }

    public BatchStepExecutionContext getStepExecution() {
        return stepExecution;
    }

    public void setStepExecution(BatchStepExecutionContext stepExecution) {
        this.stepExecution = stepExecution;
    }

    public List<BatchJobExecutionContext> getBatchJobExecutionContextList() {
        return batchJobExecutionContextList;
    }

    public void setBatchJobExecutionContextList(List<BatchJobExecutionContext> batchJobExecutionContextList) {
        this.batchJobExecutionContextList = batchJobExecutionContextList;
    }

    public List<BatchJobExecutionParams> getBatchJobExecutionParamsList() {
        return batchJobExecutionParamsList;
    }

    public void setBatchJobExecutionParamsList(List<BatchJobExecutionParams> batchJobExecutionParamsList) {
        this.batchJobExecutionParamsList = batchJobExecutionParamsList;
    }

    public List<BatchStepExecution> getBatchStepExecutionList() {
        return batchStepExecutionList;
    }

    public void setBatchStepExecutionList(List<BatchStepExecution> batchStepExecutionList) {
        this.batchStepExecutionList = batchStepExecutionList;
    }

    public static class Builder {

        private BatchJobExecution instance = new BatchJobExecution();

        public Builder jobExecutionID(Integer jobExecutionID) {
            instance.setJobExecutionID(jobExecutionID);
            return this;
        }

        public Builder version(java.math.BigDecimal version) {
            instance.setVersion(version);
            return this;
        }

        public Builder jobInstanceID(Integer jobInstanceID) {
            instance.setJobInstanceID(jobInstanceID);
            return this;
        }

        public Builder createTime(String createTime) {
            instance.setCreateTime(createTime);
            return this;
        }

        public Builder startTime(String startTime) {
            instance.setStartTime(startTime);
            return this;
        }

        public Builder endTime(String endTime) {
            instance.setEndTime(endTime);
            return this;
        }

        public Builder status(String status) {
            instance.setStatus(status);
            return this;
        }

        public Builder exitCode(String exitCode) {
            instance.setExitCode(exitCode);
            return this;
        }

        public Builder exitMessage(String exitMessage) {
            instance.setExitMessage(exitMessage);
            return this;
        }

        public Builder lastUpdated(String lastUpdated) {
            instance.setLastUpdated(lastUpdated);
            return this;
        }

        public Builder jobConfigurationLocation(String jobConfigurationLocation) {
            instance.setJobConfigurationLocation(jobConfigurationLocation);
            return this;
        }

        public Builder jobInstance(BatchJobInstance jobInstance) {
            instance.setJobInstance(jobInstance);
            return this;
        }

        public Builder jobExecution(BatchJobExecutionContext jobExecution) {
            instance.setJobExecution(jobExecution);
            return this;
        }

        public Builder stepExecution(BatchStepExecutionContext stepExecution) {
            instance.setStepExecution(stepExecution);
            return this;
        }

        public Builder batchJobExecutionContextList(List<BatchJobExecutionContext> batchJobExecutionContextList) {
            instance.setBatchJobExecutionContextList(batchJobExecutionContextList);
            return this;
        }

        public Builder batchJobExecutionParamsList(List<BatchJobExecutionParams> batchJobExecutionParamsList) {
            instance.setBatchJobExecutionParamsList(batchJobExecutionParamsList);
            return this;
        }

        public Builder batchStepExecutionList(List<BatchStepExecution> batchStepExecutionList) {
            instance.setBatchStepExecutionList(batchStepExecutionList);
            return this;
        }

        public BatchJobExecution build() {
            return instance;
        }
    }
}
