package com.bsit.codegeneration.pojo;

public class QrtzPausedTriggerGrps {

    private String schedName;

    private String triggerGroup;

    public QrtzPausedTriggerGrps() {
    }

    public QrtzPausedTriggerGrps(String schedName, String triggerGroup) {
        this.schedName = schedName;
        this.triggerGroup = triggerGroup;
    }

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public static class Builder {

        private QrtzPausedTriggerGrps instance = new QrtzPausedTriggerGrps();

        public Builder schedName(String schedName) {
            instance.setSchedName(schedName);
            return this;
        }

        public Builder triggerGroup(String triggerGroup) {
            instance.setTriggerGroup(triggerGroup);
            return this;
        }

        public QrtzPausedTriggerGrps build() {
            return instance;
        }
    }
}
