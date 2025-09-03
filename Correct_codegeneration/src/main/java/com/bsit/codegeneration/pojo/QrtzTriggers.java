package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class QrtzTriggers {

    private String schedName;

    private String triggerName;

    private String triggerGroup;

    private String jobName;

    private String jobGroup;

    private String description;

    private java.math.BigDecimal nextFireTime;

    private java.math.BigDecimal prevFireTime;

    private java.math.BigDecimal priority;

    private String triggerState;

    private String triggerType;

    private java.math.BigDecimal startTime;

    private java.math.BigDecimal endTime;

    private String calendarName;

    private Integer misfireInstr;

    private byte[] jobData;

    private List<QrtzBlobTriggers> qrtzBlobTriggersList;

    private List<QrtzCronTriggers> qrtzCronTriggersList;

    private List<QrtzSimpleTriggers> qrtzSimpleTriggersList;

    private List<QrtzSimpropTriggers> qrtzSimpropTriggersList;

    public QrtzTriggers() {
    }

    public QrtzTriggers(String schedName, String triggerName, String triggerGroup, String jobName, String jobGroup, String description, java.math.BigDecimal nextFireTime, java.math.BigDecimal prevFireTime, java.math.BigDecimal priority, String triggerState, String triggerType, java.math.BigDecimal startTime, java.math.BigDecimal endTime, String calendarName, Integer misfireInstr, byte[] jobData) {
        this.schedName = schedName;
        this.triggerName = triggerName;
        this.triggerGroup = triggerGroup;
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.description = description;
        this.nextFireTime = nextFireTime;
        this.prevFireTime = prevFireTime;
        this.priority = priority;
        this.triggerState = triggerState;
        this.triggerType = triggerType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.calendarName = calendarName;
        this.misfireInstr = misfireInstr;
        this.jobData = jobData;
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

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.math.BigDecimal getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(java.math.BigDecimal nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    public java.math.BigDecimal getPrevFireTime() {
        return prevFireTime;
    }

    public void setPrevFireTime(java.math.BigDecimal prevFireTime) {
        this.prevFireTime = prevFireTime;
    }

    public java.math.BigDecimal getPriority() {
        return priority;
    }

    public void setPriority(java.math.BigDecimal priority) {
        this.priority = priority;
    }

    public String getTriggerState() {
        return triggerState;
    }

    public void setTriggerState(String triggerState) {
        this.triggerState = triggerState;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public java.math.BigDecimal getStartTime() {
        return startTime;
    }

    public void setStartTime(java.math.BigDecimal startTime) {
        this.startTime = startTime;
    }

    public java.math.BigDecimal getEndTime() {
        return endTime;
    }

    public void setEndTime(java.math.BigDecimal endTime) {
        this.endTime = endTime;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public Integer getMisfireInstr() {
        return misfireInstr;
    }

    public void setMisfireInstr(Integer misfireInstr) {
        this.misfireInstr = misfireInstr;
    }

    public byte[] getJobData() {
        return jobData;
    }

    public void setJobData(byte[] jobData) {
        this.jobData = jobData;
    }

    public List<QrtzBlobTriggers> getQrtzBlobTriggersList() {
        return qrtzBlobTriggersList;
    }

    public void setQrtzBlobTriggersList(List<QrtzBlobTriggers> qrtzBlobTriggersList) {
        this.qrtzBlobTriggersList = qrtzBlobTriggersList;
    }

    public List<QrtzCronTriggers> getQrtzCronTriggersList() {
        return qrtzCronTriggersList;
    }

    public void setQrtzCronTriggersList(List<QrtzCronTriggers> qrtzCronTriggersList) {
        this.qrtzCronTriggersList = qrtzCronTriggersList;
    }

    public List<QrtzSimpleTriggers> getQrtzSimpleTriggersList() {
        return qrtzSimpleTriggersList;
    }

    public void setQrtzSimpleTriggersList(List<QrtzSimpleTriggers> qrtzSimpleTriggersList) {
        this.qrtzSimpleTriggersList = qrtzSimpleTriggersList;
    }

    public List<QrtzSimpropTriggers> getQrtzSimpropTriggersList() {
        return qrtzSimpropTriggersList;
    }

    public void setQrtzSimpropTriggersList(List<QrtzSimpropTriggers> qrtzSimpropTriggersList) {
        this.qrtzSimpropTriggersList = qrtzSimpropTriggersList;
    }

    public static class Builder {

        private QrtzTriggers instance = new QrtzTriggers();

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

        public Builder jobName(String jobName) {
            instance.setJobName(jobName);
            return this;
        }

        public Builder jobGroup(String jobGroup) {
            instance.setJobGroup(jobGroup);
            return this;
        }

        public Builder description(String description) {
            instance.setDescription(description);
            return this;
        }

        public Builder nextFireTime(java.math.BigDecimal nextFireTime) {
            instance.setNextFireTime(nextFireTime);
            return this;
        }

        public Builder prevFireTime(java.math.BigDecimal prevFireTime) {
            instance.setPrevFireTime(prevFireTime);
            return this;
        }

        public Builder priority(java.math.BigDecimal priority) {
            instance.setPriority(priority);
            return this;
        }

        public Builder triggerState(String triggerState) {
            instance.setTriggerState(triggerState);
            return this;
        }

        public Builder triggerType(String triggerType) {
            instance.setTriggerType(triggerType);
            return this;
        }

        public Builder startTime(java.math.BigDecimal startTime) {
            instance.setStartTime(startTime);
            return this;
        }

        public Builder endTime(java.math.BigDecimal endTime) {
            instance.setEndTime(endTime);
            return this;
        }

        public Builder calendarName(String calendarName) {
            instance.setCalendarName(calendarName);
            return this;
        }

        public Builder misfireInstr(Integer misfireInstr) {
            instance.setMisfireInstr(misfireInstr);
            return this;
        }

        public Builder jobData(byte[] jobData) {
            instance.setJobData(jobData);
            return this;
        }

        public Builder qrtzBlobTriggersList(List<QrtzBlobTriggers> qrtzBlobTriggersList) {
            instance.setQrtzBlobTriggersList(qrtzBlobTriggersList);
            return this;
        }

        public Builder qrtzCronTriggersList(List<QrtzCronTriggers> qrtzCronTriggersList) {
            instance.setQrtzCronTriggersList(qrtzCronTriggersList);
            return this;
        }

        public Builder qrtzSimpleTriggersList(List<QrtzSimpleTriggers> qrtzSimpleTriggersList) {
            instance.setQrtzSimpleTriggersList(qrtzSimpleTriggersList);
            return this;
        }

        public Builder qrtzSimpropTriggersList(List<QrtzSimpropTriggers> qrtzSimpropTriggersList) {
            instance.setQrtzSimpropTriggersList(qrtzSimpropTriggersList);
            return this;
        }

        public QrtzTriggers build() {
            return instance;
        }
    }
}
