package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class BatchStepExecution {

    private Integer stepExecutionID;

    private java.math.BigDecimal version;

    private String stepName;

    private Integer jobExecutionID;

    private String createTime;

    private String startTime;

    private String endTime;

    private String status;

    private java.math.BigDecimal commitCount;

    private java.math.BigDecimal readCount;

    private java.math.BigDecimal filterCount;

    private java.math.BigDecimal writeCount;

    private java.math.BigDecimal readSkipCount;

    private java.math.BigDecimal writeSkipCount;

    private java.math.BigDecimal processSkipCount;

    private java.math.BigDecimal rollbackCount;

    private String exitCode;

    private String exitMessage;

    private String lastUpdated;

    private BatchJobExecution jobExecution;

    private BatchStepExecutionContext stepExecution;

    private List<BatchStepExecutionContext> batchStepExecutionContextList;

    public BatchStepExecution() {
    }

    public BatchStepExecution(Integer stepExecutionID, java.math.BigDecimal version, String stepName, Integer jobExecutionID, String createTime, String startTime, String endTime, String status, java.math.BigDecimal commitCount, java.math.BigDecimal readCount, java.math.BigDecimal filterCount, java.math.BigDecimal writeCount, java.math.BigDecimal readSkipCount, java.math.BigDecimal writeSkipCount, java.math.BigDecimal processSkipCount, java.math.BigDecimal rollbackCount, String exitCode, String exitMessage, String lastUpdated, BatchJobExecution jobExecution, BatchStepExecutionContext stepExecution) {
        this.stepExecutionID = stepExecutionID;
        this.version = version;
        this.stepName = stepName;
        this.jobExecutionID = jobExecutionID;
        this.createTime = createTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.commitCount = commitCount;
        this.readCount = readCount;
        this.filterCount = filterCount;
        this.writeCount = writeCount;
        this.readSkipCount = readSkipCount;
        this.writeSkipCount = writeSkipCount;
        this.processSkipCount = processSkipCount;
        this.rollbackCount = rollbackCount;
        this.exitCode = exitCode;
        this.exitMessage = exitMessage;
        this.lastUpdated = lastUpdated;
        this.jobExecution = jobExecution;
        this.stepExecution = stepExecution;
    }

    public Integer getStepExecutionID() {
        return stepExecutionID;
    }

    public void setStepExecutionID(Integer stepExecutionID) {
        this.stepExecutionID = stepExecutionID;
    }

    public java.math.BigDecimal getVersion() {
        return version;
    }

    public void setVersion(java.math.BigDecimal version) {
        this.version = version;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public Integer getJobExecutionID() {
        return jobExecutionID;
    }

    public void setJobExecutionID(Integer jobExecutionID) {
        this.jobExecutionID = jobExecutionID;
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

    public java.math.BigDecimal getCommitCount() {
        return commitCount;
    }

    public void setCommitCount(java.math.BigDecimal commitCount) {
        this.commitCount = commitCount;
    }

    public java.math.BigDecimal getReadCount() {
        return readCount;
    }

    public void setReadCount(java.math.BigDecimal readCount) {
        this.readCount = readCount;
    }

    public java.math.BigDecimal getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(java.math.BigDecimal filterCount) {
        this.filterCount = filterCount;
    }

    public java.math.BigDecimal getWriteCount() {
        return writeCount;
    }

    public void setWriteCount(java.math.BigDecimal writeCount) {
        this.writeCount = writeCount;
    }

    public java.math.BigDecimal getReadSkipCount() {
        return readSkipCount;
    }

    public void setReadSkipCount(java.math.BigDecimal readSkipCount) {
        this.readSkipCount = readSkipCount;
    }

    public java.math.BigDecimal getWriteSkipCount() {
        return writeSkipCount;
    }

    public void setWriteSkipCount(java.math.BigDecimal writeSkipCount) {
        this.writeSkipCount = writeSkipCount;
    }

    public java.math.BigDecimal getProcessSkipCount() {
        return processSkipCount;
    }

    public void setProcessSkipCount(java.math.BigDecimal processSkipCount) {
        this.processSkipCount = processSkipCount;
    }

    public java.math.BigDecimal getRollbackCount() {
        return rollbackCount;
    }

    public void setRollbackCount(java.math.BigDecimal rollbackCount) {
        this.rollbackCount = rollbackCount;
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

    public BatchJobExecution getJobExecution() {
        return jobExecution;
    }

    public void setJobExecution(BatchJobExecution jobExecution) {
        this.jobExecution = jobExecution;
    }

    public BatchStepExecutionContext getStepExecution() {
        return stepExecution;
    }

    public void setStepExecution(BatchStepExecutionContext stepExecution) {
        this.stepExecution = stepExecution;
    }

    public List<BatchStepExecutionContext> getBatchStepExecutionContextList() {
        return batchStepExecutionContextList;
    }

    public void setBatchStepExecutionContextList(List<BatchStepExecutionContext> batchStepExecutionContextList) {
        this.batchStepExecutionContextList = batchStepExecutionContextList;
    }

    public static class Builder {

        private BatchStepExecution instance = new BatchStepExecution();

        public Builder stepExecutionID(Integer stepExecutionID) {
            instance.setStepExecutionID(stepExecutionID);
            return this;
        }

        public Builder version(java.math.BigDecimal version) {
            instance.setVersion(version);
            return this;
        }

        public Builder stepName(String stepName) {
            instance.setStepName(stepName);
            return this;
        }

        public Builder jobExecutionID(Integer jobExecutionID) {
            instance.setJobExecutionID(jobExecutionID);
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

        public Builder commitCount(java.math.BigDecimal commitCount) {
            instance.setCommitCount(commitCount);
            return this;
        }

        public Builder readCount(java.math.BigDecimal readCount) {
            instance.setReadCount(readCount);
            return this;
        }

        public Builder filterCount(java.math.BigDecimal filterCount) {
            instance.setFilterCount(filterCount);
            return this;
        }

        public Builder writeCount(java.math.BigDecimal writeCount) {
            instance.setWriteCount(writeCount);
            return this;
        }

        public Builder readSkipCount(java.math.BigDecimal readSkipCount) {
            instance.setReadSkipCount(readSkipCount);
            return this;
        }

        public Builder writeSkipCount(java.math.BigDecimal writeSkipCount) {
            instance.setWriteSkipCount(writeSkipCount);
            return this;
        }

        public Builder processSkipCount(java.math.BigDecimal processSkipCount) {
            instance.setProcessSkipCount(processSkipCount);
            return this;
        }

        public Builder rollbackCount(java.math.BigDecimal rollbackCount) {
            instance.setRollbackCount(rollbackCount);
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

        public Builder jobExecution(BatchJobExecution jobExecution) {
            instance.setJobExecution(jobExecution);
            return this;
        }

        public Builder stepExecution(BatchStepExecutionContext stepExecution) {
            instance.setStepExecution(stepExecution);
            return this;
        }

        public Builder batchStepExecutionContextList(List<BatchStepExecutionContext> batchStepExecutionContextList) {
            instance.setBatchStepExecutionContextList(batchStepExecutionContextList);
            return this;
        }

        public BatchStepExecution build() {
            return instance;
        }
    }
}
