package com.bsit.codegeneration.record;

public record QrtzJobDetails(String schedName, String jobName, String jobGroup, String description, String jobClassName, String isDurable, String isNonconcurrent, String isUpdateData, String requestsRecovery, String jobData) {

    public static class Builder {

        private String schedName;

        private String jobName;

        private String jobGroup;

        private String description;

        private String jobClassName;

        private String isDurable;

        private String isNonconcurrent;

        private String isUpdateData;

        private String requestsRecovery;

        private String jobData;

        public Builder schedName(String schedName) {
            this.schedName = schedName;
            return this;
        }

        public Builder jobName(String jobName) {
            this.jobName = jobName;
            return this;
        }

        public Builder jobGroup(String jobGroup) {
            this.jobGroup = jobGroup;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder jobClassName(String jobClassName) {
            this.jobClassName = jobClassName;
            return this;
        }

        public Builder isDurable(String isDurable) {
            this.isDurable = isDurable;
            return this;
        }

        public Builder isNonconcurrent(String isNonconcurrent) {
            this.isNonconcurrent = isNonconcurrent;
            return this;
        }

        public Builder isUpdateData(String isUpdateData) {
            this.isUpdateData = isUpdateData;
            return this;
        }

        public Builder requestsRecovery(String requestsRecovery) {
            this.requestsRecovery = requestsRecovery;
            return this;
        }

        public Builder jobData(String jobData) {
            this.jobData = jobData;
            return this;
        }

        public QrtzJobDetails build() {
            return new QrtzJobDetails(schedName, jobName, jobGroup, description, jobClassName, isDurable, isNonconcurrent, isUpdateData, requestsRecovery, jobData);
        }
    }
}
