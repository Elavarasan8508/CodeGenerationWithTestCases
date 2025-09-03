package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class BatchJobExecutionParams {

    private Integer jobExecutionID;

    private String parameterName;

    private String parameterType;

    private String parameterValue;

    private String identifying;

    private Integer doubleVal;

    private java.math.BigDecimal longVal;

    private String dateVal;

    private String keyName;

    private String stringVal;

    private String typeCd;

    private BatchJobExecution jobExecution;

    public BatchJobExecutionParams() {
    }

    public BatchJobExecutionParams(Integer jobExecutionID, String parameterName, String parameterType, String parameterValue, String identifying, Integer doubleVal, java.math.BigDecimal longVal, String dateVal, String keyName, String stringVal, String typeCd, BatchJobExecution jobExecution) {
        this.jobExecutionID = jobExecutionID;
        this.parameterName = parameterName;
        this.parameterType = parameterType;
        this.parameterValue = parameterValue;
        this.identifying = identifying;
        this.doubleVal = doubleVal;
        this.longVal = longVal;
        this.dateVal = dateVal;
        this.keyName = keyName;
        this.stringVal = stringVal;
        this.typeCd = typeCd;
        this.jobExecution = jobExecution;
    }

    public Integer getJobExecutionID() {
        return jobExecutionID;
    }

    public void setJobExecutionID(Integer jobExecutionID) {
        this.jobExecutionID = jobExecutionID;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    public String getIdentifying() {
        return identifying;
    }

    public void setIdentifying(String identifying) {
        this.identifying = identifying;
    }

    public Integer getDoubleVal() {
        return doubleVal;
    }

    public void setDoubleVal(Integer doubleVal) {
        this.doubleVal = doubleVal;
    }

    public java.math.BigDecimal getLongVal() {
        return longVal;
    }

    public void setLongVal(java.math.BigDecimal longVal) {
        this.longVal = longVal;
    }

    public String getDateVal() {
        return dateVal;
    }

    public void setDateVal(String dateVal) {
        this.dateVal = dateVal;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public BatchJobExecution getJobExecution() {
        return jobExecution;
    }

    public void setJobExecution(BatchJobExecution jobExecution) {
        this.jobExecution = jobExecution;
    }

    public static class Builder {

        private BatchJobExecutionParams instance = new BatchJobExecutionParams();

        public Builder jobExecutionID(Integer jobExecutionID) {
            instance.setJobExecutionID(jobExecutionID);
            return this;
        }

        public Builder parameterName(String parameterName) {
            instance.setParameterName(parameterName);
            return this;
        }

        public Builder parameterType(String parameterType) {
            instance.setParameterType(parameterType);
            return this;
        }

        public Builder parameterValue(String parameterValue) {
            instance.setParameterValue(parameterValue);
            return this;
        }

        public Builder identifying(String identifying) {
            instance.setIdentifying(identifying);
            return this;
        }

        public Builder doubleVal(Integer doubleVal) {
            instance.setDoubleVal(doubleVal);
            return this;
        }

        public Builder longVal(java.math.BigDecimal longVal) {
            instance.setLongVal(longVal);
            return this;
        }

        public Builder dateVal(String dateVal) {
            instance.setDateVal(dateVal);
            return this;
        }

        public Builder keyName(String keyName) {
            instance.setKeyName(keyName);
            return this;
        }

        public Builder stringVal(String stringVal) {
            instance.setStringVal(stringVal);
            return this;
        }

        public Builder typeCd(String typeCd) {
            instance.setTypeCd(typeCd);
            return this;
        }

        public Builder jobExecution(BatchJobExecution jobExecution) {
            instance.setJobExecution(jobExecution);
            return this;
        }

        public BatchJobExecutionParams build() {
            return instance;
        }
    }
}
