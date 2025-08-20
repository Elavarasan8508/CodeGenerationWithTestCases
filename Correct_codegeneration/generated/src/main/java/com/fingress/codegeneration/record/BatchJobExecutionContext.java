package com.bsit.codegeneration.record;

public record BatchJobExecutionContext(Long jobExecutionID, String shortContext, String serializedContext) {

    public static class Builder {

        private Long jobExecutionID;

        private String shortContext;

        private String serializedContext;

        public Builder jobExecutionID(Long jobExecutionID) {
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

        public BatchJobExecutionContext build() {
            return new BatchJobExecutionContext(jobExecutionID, shortContext, serializedContext);
        }
    }
}
