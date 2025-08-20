package com.bsit.codegeneration.record;

public record QrtzCronTriggers(String schedName, String triggerName, String triggerGroup, String cronExpression, String timeZoneID) {

    public static class Builder {

        private String schedName;

        private String triggerName;

        private String triggerGroup;

        private String cronExpression;

        private String timeZoneID;

        public Builder schedName(String schedName) {
            this.schedName = schedName;
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

        public Builder cronExpression(String cronExpression) {
            this.cronExpression = cronExpression;
            return this;
        }

        public Builder timeZoneID(String timeZoneID) {
            this.timeZoneID = timeZoneID;
            return this;
        }

        public QrtzCronTriggers build() {
            return new QrtzCronTriggers(schedName, triggerName, triggerGroup, cronExpression, timeZoneID);
        }
    }
}
