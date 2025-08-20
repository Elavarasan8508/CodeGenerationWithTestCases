package com.bsit.codegeneration.record;

public record BatchJobExecution(Long jobExecutionID, Long version, Long jobInstanceID, String createTime, String startTime, String endTime, String status, String exitCode, String exitMessage, String lastUpdated, String jobConfigurationLocation) {

    public static class Builder {

        private Long jobExecutionID;

        private Long version;

        private Long jobInstanceID;

        private String createTime;

        private String startTime;

        private String endTime;

        private String status;

        private String exitCode;

        private String exitMessage;

        private String lastUpdated;

        private String jobConfigurationLocation;

        public Builder jobExecutionID(Long jobExecutionID) {
            this.jobExecutionID = jobExecutionID;
            return this;
        }

        public Builder version(Long version) {
            this.version = version;
            return this;
        }

        public Builder jobInstanceID(Long jobInstanceID) {
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

        public BatchJobExecution build() {
            return new BatchJobExecution(jobExecutionID, version, jobInstanceID, createTime, startTime, endTime, status, exitCode, exitMessage, lastUpdated, jobConfigurationLocation);
        }
    }
}
