package com.bsit.codegeneration.pojo;

public class QrtzBlobTriggers {

    private String schedName;

    private String triggerName;

    private String triggerGroup;

    private byte[] blobData;

    public QrtzBlobTriggers() {
    }

    public QrtzBlobTriggers(String schedName, String triggerName, String triggerGroup, byte[] blobData) {
        this.schedName = schedName;
        this.triggerName = triggerName;
        this.triggerGroup = triggerGroup;
        this.blobData = blobData;
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

    public byte[] getBlobData() {
        return blobData;
    }

    public void setBlobData(byte[] blobData) {
        this.blobData = blobData;
    }

    public static class Builder {

        private QrtzBlobTriggers instance = new QrtzBlobTriggers();

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

        public Builder blobData(byte[] blobData) {
            instance.setBlobData(blobData);
            return this;
        }

        public QrtzBlobTriggers build() {
            return instance;
        }
    }
}
