package com.bsit.codegeneration.record;

public record QrtzTriggers(String schedName, String triggerName, String triggerGroup, String jobName, String jobGroup, String description, Long nextFireTime, Long prevFireTime, Long priority, String triggerState, String triggerType, Long startTime, Long endTime, String calendarName, Long misfireInstr, String jobData) {

    public static class Builder {

        private String schedName;

        private String triggerName;

        private String triggerGroup;

        private String jobName;

        private String jobGroup;

        private String description;

        private Long nextFireTime;

        private Long prevFireTime;

        private Long priority;

        private String triggerState;

        private String triggerType;

        private Long startTime;

        private Long endTime;

        private String calendarName;

        private Long misfireInstr;

        private String jobData;

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

        public Builder nextFireTime(Long nextFireTime) {
            this.nextFireTime = nextFireTime;
            return this;
        }

        public Builder prevFireTime(Long prevFireTime) {
            this.prevFireTime = prevFireTime;
            return this;
        }

        public Builder priority(Long priority) {
            this.priority = priority;
            return this;
        }

        public Builder triggerState(String triggerState) {
            this.triggerState = triggerState;
            return this;
        }

        public Builder triggerType(String triggerType) {
            this.triggerType = triggerType;
            return this;
        }

        public Builder startTime(Long startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(Long endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder calendarName(String calendarName) {
            this.calendarName = calendarName;
            return this;
        }

        public Builder misfireInstr(Long misfireInstr) {
            this.misfireInstr = misfireInstr;
            return this;
        }

        public Builder jobData(String jobData) {
            this.jobData = jobData;
            return this;
        }

        public QrtzTriggers build() {
            return new QrtzTriggers(schedName, triggerName, triggerGroup, jobName, jobGroup, description, nextFireTime, prevFireTime, priority, triggerState, triggerType, startTime, endTime, calendarName, misfireInstr, jobData);
        }
    }
}
