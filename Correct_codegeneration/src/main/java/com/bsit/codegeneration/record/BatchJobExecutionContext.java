package com.bsit.codegeneration.record;

import java.util.List;

public record BatchJobExecutionContext(Integer jobExecutionID, String shortContext, String serializedContext, BatchJobExecution batchJobExecution) {

    public static class Builder {

        private Integer jobExecutionID;

        private String shortContext;

        private String serializedContext;

        private BatchJobExecution batchJobExecution;

        public Builder jobExecutionID(Integer jobExecutionID) {
            this.jobExecutionID = jobExecutionID;
            return this;
        }

        public Builder shortContext(String shortContext) {
            this.shortContext = shortContext;
            return this;
        }

        public Builder serializedContext(String serializedContext) {
            this.serializedContext = serializedContext;
            return this;
        }

        public Builder batchJobExecution(BatchJobExecution batchJobExecution) {
            this.batchJobExecution = batchJobExecution;
            return this;
        }

        public BatchJobExecutionContext build() {
            return new BatchJobExecutionContext(jobExecutionID, shortContext, serializedContext, batchJobExecution);
        }
    }
}
