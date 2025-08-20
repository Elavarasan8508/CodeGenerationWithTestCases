package com.bsit.codegeneration.record;

public record LoanEodStatus(String jobID, String jobName, String jobStatus, String jobExitCode, String eodStartDate, String eodEndDate, String remarks, String status) {

    public static class Builder {

        private String jobID;

        private String jobName;

        private String jobStatus;

        private String jobExitCode;

        private String eodStartDate;

        private String eodEndDate;

        private String remarks;

        private String status;

        public Builder jobID(String jobID) {
            this.jobID = jobID;
            return this;
        }

        public Builder jobName(String jobName) {
            this.jobName = jobName;
            return this;
        }

        public Builder jobStatus(String jobStatus) {
            this.jobStatus = jobStatus;
            return this;
        }

        public Builder jobExitCode(String jobExitCode) {
            this.jobExitCode = jobExitCode;
            return this;
        }

        public Builder eodStartDate(String eodStartDate) {
            this.eodStartDate = eodStartDate;
            return this;
        }

        public Builder eodEndDate(String eodEndDate) {
            this.eodEndDate = eodEndDate;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public LoanEodStatus build() {
            return new LoanEodStatus(jobID, jobName, jobStatus, jobExitCode, eodStartDate, eodEndDate, remarks, status);
        }
    }
}
