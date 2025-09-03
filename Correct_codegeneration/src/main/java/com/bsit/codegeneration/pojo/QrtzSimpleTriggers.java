package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class QrtzSimpleTriggers {

    private String schedName;

    private String triggerName;

    private String triggerGroup;

    private Integer repeatCount;

    private java.math.BigDecimal repeatInterval;

    private Long timesTriggered;

    public QrtzSimpleTriggers() {
    }

    public QrtzSimpleTriggers(String schedName, String triggerName, String triggerGroup, Integer repeatCount, java.math.BigDecimal repeatInterval, Long timesTriggered) {
        this.schedName = schedName;
        this.triggerName = triggerName;
        this.triggerGroup = triggerGroup;
        this.repeatCount = repeatCount;
        this.repeatInterval = repeatInterval;
        this.timesTriggered = timesTriggered;
    }

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public Integer getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }

    public java.math.BigDecimal getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(java.math.BigDecimal repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public Long getTimesTriggered() {
        return timesTriggered;
    }

    public void setTimesTriggered(Long timesTriggered) {
        this.timesTriggered = timesTriggered;
    }

    public static class Builder {

        private QrtzSimpleTriggers instance = new QrtzSimpleTriggers();

        public Builder schedName(String schedName) {
            instance.setSchedName(schedName);
            return this;
        }

        public Builder triggerName(String triggerName) {
            instance.setTriggerName(triggerName);
            return this;
        }

        public Builder triggerGroup(String triggerGroup) {
            instance.setTriggerGroup(triggerGroup);
            return this;
        }

        public Builder repeatCount(Integer repeatCount) {
            instance.setRepeatCount(repeatCount);
            return this;
        }

        public Builder repeatInterval(java.math.BigDecimal repeatInterval) {
            instance.setRepeatInterval(repeatInterval);
            return this;
        }

        public Builder timesTriggered(Long timesTriggered) {
            instance.setTimesTriggered(timesTriggered);
            return this;
        }

        public QrtzSimpleTriggers build() {
            return instance;
        }
    }
}
