package com.bsit.codegeneration.pojo;

public class QrtzCronTriggers {

    private String schedName;

    private String triggerName;

    private String triggerGroup;

    private String cronExpression;

    private Integer timeZoneID;

    public QrtzCronTriggers() {
    }

    public QrtzCronTriggers(String schedName, String triggerName, String triggerGroup, String cronExpression, Integer timeZoneID) {
        this.schedName = schedName;
        this.triggerName = triggerName;
        this.triggerGroup = triggerGroup;
        this.cronExpression = cronExpression;
        this.timeZoneID = timeZoneID;
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

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Integer getTimeZoneID() {
        return timeZoneID;
    }

    public void setTimeZoneID(Integer timeZoneID) {
        this.timeZoneID = timeZoneID;
    }

    public static class Builder {

        private QrtzCronTriggers instance = new QrtzCronTriggers();

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

        public Builder cronExpression(String cronExpression) {
            instance.setCronExpression(cronExpression);
            return this;
        }

        public Builder timeZoneID(Integer timeZoneID) {
            instance.setTimeZoneID(timeZoneID);
            return this;
        }

        public QrtzCronTriggers build() {
            return instance;
        }
    }
}
