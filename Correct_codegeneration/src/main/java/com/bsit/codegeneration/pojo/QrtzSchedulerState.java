package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class QrtzSchedulerState {

    private String schedName;

    private String instanceName;

    private java.math.BigDecimal lastCheckinTime;

    private java.math.BigDecimal checkinInterval;

    public QrtzSchedulerState() {
    }

    public QrtzSchedulerState(String schedName, String instanceName, java.math.BigDecimal lastCheckinTime, java.math.BigDecimal checkinInterval) {
        this.schedName = schedName;
        this.instanceName = instanceName;
        this.lastCheckinTime = lastCheckinTime;
        this.checkinInterval = checkinInterval;
    }

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public java.math.BigDecimal getLastCheckinTime() {
        return lastCheckinTime;
    }

    public void setLastCheckinTime(java.math.BigDecimal lastCheckinTime) {
        this.lastCheckinTime = lastCheckinTime;
    }

    public java.math.BigDecimal getCheckinInterval() {
        return checkinInterval;
    }

    public void setCheckinInterval(java.math.BigDecimal checkinInterval) {
        this.checkinInterval = checkinInterval;
    }

    public static class Builder {

        private QrtzSchedulerState instance = new QrtzSchedulerState();

        public Builder schedName(String schedName) {
            instance.setSchedName(schedName);
            return this;
        }

        public Builder instanceName(String instanceName) {
            instance.setInstanceName(instanceName);
            return this;
        }

        public Builder lastCheckinTime(java.math.BigDecimal lastCheckinTime) {
            instance.setLastCheckinTime(lastCheckinTime);
            return this;
        }

        public Builder checkinInterval(java.math.BigDecimal checkinInterval) {
            instance.setCheckinInterval(checkinInterval);
            return this;
        }

        public QrtzSchedulerState build() {
            return instance;
        }
    }
}
