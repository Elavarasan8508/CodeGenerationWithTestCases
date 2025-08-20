package com.bsit.codegeneration.record;

public record BatchStepExecution(Long stepExecutionID, Long version, String stepName, Long jobExecutionID, String createTime, String startTime, String endTime, String status, Long commitCount, Long readCount, Long filterCount, Long writeCount, Long readSkipCount, Long writeSkipCount, Long processSkipCount, Long rollbackCount, String exitCode, String exitMessage, String lastUpdated) {

    public static class Builder {

        private Long stepExecutionID;

        private Long version;

        private String stepName;

        private Long jobExecutionID;

        private String createTime;

        private String startTime;

        private String endTime;

        private String status;

        private Long commitCount;

        private Long readCount;

        private Long filterCount;

        private Long writeCount;

        private Long readSkipCount;

        private Long writeSkipCount;

        private Long processSkipCount;

        private Long rollbackCount;

        private String exitCode;

        private String exitMessage;

        private String lastUpdated;

        public Builder stepExecutionID(Long stepExecutionID) {
            this.stepExecutionID = stepExecutionID;
            return this;
        }

        public Builder version(Long version) {
            this.version = version;
            return this;
        }

        public Builder stepName(String stepName) {
            this.stepName = stepName;
            return this;
        }

        public Builder jobExecutionID(Long jobExecutionID) {
            this.jobExecutionID = jobExecutionID;
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

        public Builder commitCount(Long commitCount) {
            this.commitCount = commitCount;
            return this;
        }

        public Builder readCount(Long readCount) {
            this.readCount = readCount;
            return this;
        }

        public Builder filterCount(Long filterCount) {
            this.filterCount = filterCount;
            return this;
        }

        public Builder writeCount(Long writeCount) {
            this.writeCount = writeCount;
            return this;
        }

        public Builder readSkipCount(Long readSkipCount) {
            this.readSkipCount = readSkipCount;
            return this;
        }

        public Builder writeSkipCount(Long writeSkipCount) {
            this.writeSkipCount = writeSkipCount;
            return this;
        }

        public Builder processSkipCount(Long processSkipCount) {
            this.processSkipCount = processSkipCount;
            return this;
        }

        public Builder rollbackCount(Long rollbackCount) {
            this.rollbackCount = rollbackCount;
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

        public BatchStepExecution build() {
            return new BatchStepExecution(stepExecutionID, version, stepName, jobExecutionID, createTime, startTime, endTime, status, commitCount, readCount, filterCount, writeCount, readSkipCount, writeSkipCount, processSkipCount, rollbackCount, exitCode, exitMessage, lastUpdated);
        }
    }
}
