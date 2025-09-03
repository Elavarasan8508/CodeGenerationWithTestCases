package com.bsit.codegeneration.pojo;

public class BatchJobExecutionContext {

    private Integer jobExecutionID;

    private String shortContext;

    private String serializedContext;

    private BatchJobExecution jobExecution;

    public BatchJobExecutionContext() {
    }

    public BatchJobExecutionContext(Integer jobExecutionID, String shortContext, String serializedContext, BatchJobExecution jobExecution) {
        this.jobExecutionID = jobExecutionID;
        this.shortContext = shortContext;
        this.serializedContext = serializedContext;
        this.jobExecution = jobExecution;
    }

    public Integer getJobExecutionID() {
        return jobExecutionID;
    }

    public void setJobExecutionID(Integer jobExecutionID) {
        this.jobExecutionID = jobExecutionID;
    }

    public String getShortContext() {
        return shortContext;
    }

    public void setShortContext(String shortContext) {
        this.shortContext = shortContext;
    }

    public String getSerializedContext() {
        return serializedContext;
    }

    public void setSerializedContext(String serializedContext) {
        this.serializedContext = serializedContext;
    }

    public BatchJobExecution getJobExecution() {
        return jobExecution;
    }

    public void setJobExecution(BatchJobExecution jobExecution) {
        this.jobExecution = jobExecution;
    }

    public static class Builder {

        private BatchJobExecutionContext instance = new BatchJobExecutionContext();

        public Builder jobExecutionID(Integer jobExecutionID) {
            instance.setJobExecutionID(jobExecutionID);
            return this;
        }

        public Builder shortContext(String shortContext) {
            instance.setShortContext(shortContext);
            return this;
        }

        public Builder serializedContext(String serializedContext) {
            instance.setSerializedContext(serializedContext);
            return this;
        }

        public Builder jobExecution(BatchJobExecution jobExecution) {
            instance.setJobExecution(jobExecution);
            return this;
        }

        public BatchJobExecutionContext build() {
            return instance;
        }
    }
}
