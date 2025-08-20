package com.bsit.codegeneration.record;

public record QrtzSchedulerState(String schedName, String instanceName, Long lastCheckinTime, Long checkinInterval) {

    public static class Builder {

        private String schedName;

        private String instanceName;

        private Long lastCheckinTime;

        private Long checkinInterval;

        public Builder schedName(String schedName) {
            this.schedName = schedName;
            return this;
        }

        public Builder instanceName(String instanceName) {
            this.instanceName = instanceName;
            return this;
        }

        public Builder lastCheckinTime(Long lastCheckinTime) {
            this.lastCheckinTime = lastCheckinTime;
            return this;
        }

        public Builder checkinInterval(Long checkinInterval) {
            this.checkinInterval = checkinInterval;
            return this;
        }

        public QrtzSchedulerState build() {
            return new QrtzSchedulerState(schedName, instanceName, lastCheckinTime, checkinInterval);
        }
    }
}
