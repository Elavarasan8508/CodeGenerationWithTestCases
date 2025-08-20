package com.bsit.codegeneration.record;

public record QrtzSimpleTriggers(String schedName, String triggerName, String triggerGroup, Long repeatCount, Long repeatInterval, Long timesTriggered) {

    public static class Builder {

        private String schedName;

        private String triggerName;

        private String triggerGroup;

        private Long repeatCount;

        private Long repeatInterval;

        private Long timesTriggered;

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

        public Builder repeatCount(Long repeatCount) {
            this.repeatCount = repeatCount;
            return this;
        }

        public Builder repeatInterval(Long repeatInterval) {
            this.repeatInterval = repeatInterval;
            return this;
        }

        public Builder timesTriggered(Long timesTriggered) {
            this.timesTriggered = timesTriggered;
            return this;
        }

        public QrtzSimpleTriggers build() {
            return new QrtzSimpleTriggers(schedName, triggerName, triggerGroup, repeatCount, repeatInterval, timesTriggered);
        }
    }
}
