package com.bsit.codegeneration.record;

import java.util.List;

public record BatchJobInstance(Integer jobInstanceID, Long version, String jobName, String jobKey, List<BatchJobExecution> batchJobExecutions) {

    public static class Builder {

        private Integer jobInstanceID;

        private Long version;

        private String jobName;

        private String jobKey;

        private List<BatchJobExecution> batchJobExecutions;

        public Builder jobInstanceID(Integer jobInstanceID) {
            this.jobInstanceID = jobInstanceID;
            return this;
        }

        public Builder version(Long version) {
            this.version = version;
            return this;
        }

        public Builder jobName(String jobName) {
            this.jobName = jobName;
            return this;
        }

        public Builder jobKey(String jobKey) {
            this.jobKey = jobKey;
            return this;
        }

        public Builder batchJobExecutions(List<BatchJobExecution> batchJobExecutions) {
            this.batchJobExecutions = batchJobExecutions;
            return this;
        }

        public BatchJobInstance build() {
            return new BatchJobInstance(jobInstanceID, version, jobName, jobKey, batchJobExecutions);
        }
    }
}
