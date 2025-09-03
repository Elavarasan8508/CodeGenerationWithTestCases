package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class QrtzFiredTriggers {

    private String schedName;

    private Integer entryID;

    private String triggerName;

    private String triggerGroup;

    private String instanceName;

    private java.math.BigDecimal firedTime;

    private java.math.BigDecimal schedTime;

    private java.math.BigDecimal priority;

    private String state;

    private String jobName;

    private String jobGroup;

    private String isNonconcurrent;

    private String requestsRecovery;

    public QrtzFiredTriggers() {
    }

    public QrtzFiredTriggers(String schedName, Integer entryID, String triggerName, String triggerGroup, String instanceName, java.math.BigDecimal firedTime, java.math.BigDecimal schedTime, java.math.BigDecimal priority, String state, String jobName, String jobGroup, String isNonconcurrent, String requestsRecovery) {
        this.schedName = schedName;
        this.entryID = entryID;
        this.triggerName = triggerName;
        this.triggerGroup = triggerGroup;
        this.instanceName = instanceName;
        this.firedTime = firedTime;
        this.schedTime = schedTime;
        this.priority = priority;
        this.state = state;
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.isNonconcurrent = isNonconcurrent;
        this.requestsRecovery = requestsRecovery;
    }

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public Integer getEntryID() {
        return entryID;
    }

    public void setEntryID(Integer entryID) {
        this.entryID = entryID;
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

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public java.math.BigDecimal getFiredTime() {
        return firedTime;
    }

    public void setFiredTime(java.math.BigDecimal firedTime) {
        this.firedTime = firedTime;
    }

    public java.math.BigDecimal getSchedTime() {
        return schedTime;
    }

    public void setSchedTime(java.math.BigDecimal schedTime) {
        this.schedTime = schedTime;
    }

    public java.math.BigDecimal getPriority() {
        return priority;
    }

    public void setPriority(java.math.BigDecimal priority) {
        this.priority = priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getIsNonconcurrent() {
        return isNonconcurrent;
    }

    public void setIsNonconcurrent(String isNonconcurrent) {
        this.isNonconcurrent = isNonconcurrent;
    }

    public String getRequestsRecovery() {
        return requestsRecovery;
    }

    public void setRequestsRecovery(String requestsRecovery) {
        this.requestsRecovery = requestsRecovery;
    }

    public static class Builder {

        private QrtzFiredTriggers instance = new QrtzFiredTriggers();

        public Builder schedName(String schedName) {
            instance.setSchedName(schedName);
            return this;
        }

        public Builder entryID(Integer entryID) {
            instance.setEntryID(entryID);
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

        public Builder instanceName(String instanceName) {
            instance.setInstanceName(instanceName);
            return this;
        }

        public Builder firedTime(java.math.BigDecimal firedTime) {
            instance.setFiredTime(firedTime);
            return this;
        }

        public Builder schedTime(java.math.BigDecimal schedTime) {
            instance.setSchedTime(schedTime);
            return this;
        }

        public Builder priority(java.math.BigDecimal priority) {
            instance.setPriority(priority);
            return this;
        }

        public Builder state(String state) {
            instance.setState(state);
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

        public Builder isNonconcurrent(String isNonconcurrent) {
            instance.setIsNonconcurrent(isNonconcurrent);
            return this;
        }

        public Builder requestsRecovery(String requestsRecovery) {
            instance.setRequestsRecovery(requestsRecovery);
            return this;
        }

        public QrtzFiredTriggers build() {
            return instance;
        }
    }
}
