package com.bsit.codegeneration.record;

import java.util.List;

public record BatchJobExecution(Integer jobExecutionID, Long version, Integer jobInstanceID, String createTime, String startTime, String endTime, String status, String exitCode, String exitMessage, String lastUpdated, String jobConfigurationLocation, BatchJobInstance batchJobInstance, List<BatchJobExecutionContext> batchJobExecutionContexts, List<BatchJobExecutionParams> batchJobExecutionParamss, List<BatchStepExecution> batchStepExecutions, List<BatchStepExecutionContext> batchStepExecutionContexts) {

    public static class Builder {

        private Integer jobExecutionID;

        private Long version;

        private Integer jobInstanceID;

        private String createTime;

        private String startTime;

        private String endTime;

        private String status;

        private String exitCode;

        private String exitMessage;

        private String lastUpdated;

        private String jobConfigurationLocation;

        private BatchJobInstance batchJobInstance;

        private List<BatchJobExecutionContext> batchJobExecutionContexts;

        private List<BatchJobExecutionParams> batchJobExecutionParamss;

        private List<BatchStepExecution> batchStepExecutions;

        private List<BatchStepExecutionContext> batchStepExecutionContexts;

        public Builder jobExecutionID(Integer jobExecutionID) {
            this.jobExecutionID = jobExecutionID;
            return this;
        }

        public Builder version(Long version) {
            this.version = version;
            return this;
        }

        public Builder jobInstanceID(Integer jobInstanceID) {
            this.jobInstanceID = jobInstanceID;
            return this;
        }

        public Builder createTime(String createTime) {
            this.createTime = createTime;
            return this;
        }

        public Builder startTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder exitCode(String exitCode) {
            this.exitCode = exitCode;
            return this;
        }

        public Builder exitMessage(String exitMessage) {
            this.exitMessage = exitMessage;
            return this;
        }

        public Builder lastUpdated(String lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }

        public Builder jobConfigurationLocation(String jobConfigurationLocation) {
            this.jobConfigurationLocation = jobConfigurationLocation;
            return this;
        }

        public Builder batchJobInstance(BatchJobInstance batchJobInstance) {
            this.batchJobInstance = batchJobInstance;
            return this;
        }

        public Builder batchJobExecutionContexts(List<BatchJobExecutionContext> batchJobExecutionContexts) {
            this.batchJobExecutionContexts = batchJobExecutionContexts;
            return this;
        }

        public Builder batchJobExecutionParamss(List<BatchJobExecutionParams> batchJobExecutionParamss) {
            this.batchJobExecutionParamss = batchJobExecutionParamss;
            return this;
        }

        public Builder batchStepExecutions(List<BatchStepExecution> batchStepExecutions) {
            this.batchStepExecutions = batchStepExecutions;
            return this;
        }

        public Builder batchStepExecutionContexts(List<BatchStepExecutionContext> batchStepExecutionContexts) {
            this.batchStepExecutionContexts = batchStepExecutionContexts;
            return this;
        }

        public BatchJobExecution build() {
            return new BatchJobExecution(jobExecutionID, version, jobInstanceID, createTime, startTime, endTime, status, exitCode, exitMessage, lastUpdated, jobConfigurationLocation, batchJobInstance, batchJobExecutionContexts, batchJobExecutionParamss, batchStepExecutions, batchStepExecutionContexts);
        }
    }
}
