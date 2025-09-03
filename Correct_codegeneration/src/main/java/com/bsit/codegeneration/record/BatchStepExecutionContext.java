package com.bsit.codegeneration.record;

import java.util.List;

public record BatchStepExecutionContext(Integer stepExecutionID, String shortContext, String serializedContext, BatchStepExecution batchStepExecution, List<BatchJobExecution> batchJobExecutions) {

    public static class Builder {

        private Integer stepExecutionID;

        private String shortContext;

        private String serializedContext;

        private BatchStepExecution batchStepExecution;

        private List<BatchJobExecution> batchJobExecutions;

        public Builder stepExecutionID(Integer stepExecutionID) {
            this.stepExecutionID = stepExecutionID;
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

        public Builder batchStepExecution(BatchStepExecution batchStepExecution) {
            this.batchStepExecution = batchStepExecution;
            return this;
        }

        public Builder batchJobExecutions(List<BatchJobExecution> batchJobExecutions) {
            this.batchJobExecutions = batchJobExecutions;
            return this;
        }

        public BatchStepExecutionContext build() {
            return new BatchStepExecutionContext(stepExecutionID, shortContext, serializedContext, batchStepExecution, batchJobExecutions);
        }
    }
}
