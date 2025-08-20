package com.bsit.codegeneration.record;

public record BatchJobInstance(Long jobInstanceID, Long version, String jobName, String jobKey) {

    public static class Builder {

        private Long jobInstanceID;

        private Long version;

        private String jobName;

        private String jobKey;

        public Builder jobInstanceID(Long jobInstanceID) {
            this.jobInstanceID = jobInstanceID;
            return this;
        }

        public Builder version(Long version) {
            this.version = version;
            return this;
        }

        public Builder jobName(String jobName) {
            this.jobName = jobName;
            return this;
        }

        public Builder jobKey(String jobKey) {
            this.jobKey = jobKey;
            return this;
        }

        public BatchJobInstance build() {
            return new BatchJobInstance(jobInstanceID, version, jobName, jobKey);
        }
    }
}
