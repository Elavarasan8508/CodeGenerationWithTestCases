package com.bsit.codegeneration.record;

public record QrtzPausedTriggerGrps(String schedName, String triggerGroup) {

    public static class Builder {

        private String schedName;

        private String triggerGroup;

        public Builder schedName(String schedName) {
            this.schedName = schedName;
            return this;
        }

        public Builder triggerGroup(String triggerGroup) {
            this.triggerGroup = triggerGroup;
            return this;
        }

        public QrtzPausedTriggerGrps build() {
            return new QrtzPausedTriggerGrps(schedName, triggerGroup);
        }
    }
}
