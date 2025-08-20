package com.bsit.codegeneration.record;

public record QrtzFiredTriggers(String schedName, String entryID, String triggerName, String triggerGroup, String instanceName, Long firedTime, Long schedTime, Long priority, String state, String jobName, String jobGroup, String isNonconcurrent, String requestsRecovery) {

    public static class Builder {

        private String schedName;

        private String entryID;

        private String triggerName;

        private String triggerGroup;

        private String instanceName;

        private Long firedTime;

        private Long schedTime;

        private Long priority;

        private String state;

        private String jobName;

        private String jobGroup;

        private String isNonconcurrent;

        private String requestsRecovery;

        public Builder schedName(String schedName) {
            this.schedName = schedName;
            return this;
        }

        public Builder entryID(String entryID) {
            this.entryID = entryID;
            return this;
        }

        public Builder triggerName(String triggerName) {
            this.triggerName = triggerName;
            return this;
        }

        public Builder triggerGroup(String triggerGroup) {
            this.triggerGroup = triggerGroup;
            return this;
        }

        public Builder instanceName(String instanceName) {
            this.instanceName = instanceName;
            return this;
        }

        public Builder firedTime(Long firedTime) {
            this.firedTime = firedTime;
            return this;
        }

        public Builder schedTime(Long schedTime) {
            this.schedTime = schedTime;
            return this;
        }

        public Builder priority(Long priority) {
            this.priority = priority;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
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

        public Builder isNonconcurrent(String isNonconcurrent) {
            this.isNonconcurrent = isNonconcurrent;
            return this;
        }

        public Builder requestsRecovery(String requestsRecovery) {
            this.requestsRecovery = requestsRecovery;
            return this;
        }

        public QrtzFiredTriggers build() {
            return new QrtzFiredTriggers(schedName, entryID, triggerName, triggerGroup, instanceName, firedTime, schedTime, priority, state, jobName, jobGroup, isNonconcurrent, requestsRecovery);
        }
    }
}
