package com.bsit.codegeneration.record;

public record BatchStepExecutionContext(Long stepExecutionID, String shortContext, String serializedContext) {

    public static class Builder {

        private Long stepExecutionID;

        private String shortContext;

        private String serializedContext;

        public Builder stepExecutionID(Long stepExecutionID) {
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

        public BatchStepExecutionContext build() {
            return new BatchStepExecutionContext(stepExecutionID, shortContext, serializedContext);
        }
    }
}
