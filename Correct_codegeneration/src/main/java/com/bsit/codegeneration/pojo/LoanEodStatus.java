package com.bsit.codegeneration.pojo;

public class LoanEodStatus {

    private Integer jobID;

    private String jobName;

    private String jobStatus;

    private String jobExitCode;

    private String eodStartDate;

    private String eodEndDate;

    private String remarks;

    private String status;

    public LoanEodStatus() {
    }

    public LoanEodStatus(Integer jobID, String jobName, String jobStatus, String jobExitCode, String eodStartDate, String eodEndDate, String remarks, String status) {
        this.jobID = jobID;
        this.jobName = jobName;
        this.jobStatus = jobStatus;
        this.jobExitCode = jobExitCode;
        this.eodStartDate = eodStartDate;
        this.eodEndDate = eodEndDate;
        this.remarks = remarks;
        this.status = status;
    }

    public Integer getJobID() {
        return jobID;
    }

    public void setJobID(Integer jobID) {
        this.jobID = jobID;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobExitCode() {
        return jobExitCode;
    }

    public void setJobExitCode(String jobExitCode) {
        this.jobExitCode = jobExitCode;
    }

    public String getEodStartDate() {
        return eodStartDate;
    }

    public void setEodStartDate(String eodStartDate) {
        this.eodStartDate = eodStartDate;
    }

    public String getEodEndDate() {
        return eodEndDate;
    }

    public void setEodEndDate(String eodEndDate) {
        this.eodEndDate = eodEndDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Builder {

        private LoanEodStatus instance = new LoanEodStatus();

        public Builder jobID(Integer jobID) {
            instance.setJobID(jobID);
            return this;
        }

        public Builder jobName(String jobName) {
            instance.setJobName(jobName);
            return this;
        }

        public Builder jobStatus(String jobStatus) {
            instance.setJobStatus(jobStatus);
            return this;
        }

        public Builder jobExitCode(String jobExitCode) {
            instance.setJobExitCode(jobExitCode);
            return this;
        }

        public Builder eodStartDate(String eodStartDate) {
            instance.setEodStartDate(eodStartDate);
            return this;
        }

        public Builder eodEndDate(String eodEndDate) {
            instance.setEodEndDate(eodEndDate);
            return this;
        }

        public Builder remarks(String remarks) {
            instance.setRemarks(remarks);
            return this;
        }

        public Builder status(String status) {
            instance.setStatus(status);
            return this;
        }

        public LoanEodStatus build() {
            return instance;
        }
    }
}
