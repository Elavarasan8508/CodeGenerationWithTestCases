package com.bsit.codegeneration.pojo;

public class BatchStepExecutionContext {

    private Integer stepExecutionID;

    private String shortContext;

    private String serializedContext;

    private BatchStepExecution stepExecution;

    private BatchJobExecution jobExecution;

    public BatchStepExecutionContext() {
    }

    public BatchStepExecutionContext(Integer stepExecutionID, String shortContext, String serializedContext, BatchStepExecution stepExecution, BatchJobExecution jobExecution) {
        this.stepExecutionID = stepExecutionID;
        this.shortContext = shortContext;
        this.serializedContext = serializedContext;
        this.stepExecution = stepExecution;
        this.jobExecution = jobExecution;
    }

    public Integer getStepExecutionID() {
        return stepExecutionID;
    }

    public void setStepExecutionID(Integer stepExecutionID) {
        this.stepExecutionID = stepExecutionID;
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

    public BatchStepExecution getStepExecution() {
        return stepExecution;
    }

    public void setStepExecution(BatchStepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    public BatchJobExecution getJobExecution() {
        return jobExecution;
    }

    public void setJobExecution(BatchJobExecution jobExecution) {
        this.jobExecution = jobExecution;
    }

    public static class Builder {

        private BatchStepExecutionContext instance = new BatchStepExecutionContext();

        public Builder stepExecutionID(Integer stepExecutionID) {
            instance.setStepExecutionID(stepExecutionID);
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

        public Builder stepExecution(BatchStepExecution stepExecution) {
            instance.setStepExecution(stepExecution);
            return this;
        }

        public Builder jobExecution(BatchJobExecution jobExecution) {
            instance.setJobExecution(jobExecution);
            return this;
        }

        public BatchStepExecutionContext build() {
            return instance;
        }
    }
}
