package com.bsit.codegeneration.pojo;

import java.util.List;

public class QrtzJobDetails {

    private String schedName;

    private String jobName;

    private String jobGroup;

    private String description;

    private String jobClassName;

    private String isDurable;

    private String isNonconcurrent;

    private String isUpdateData;

    private String requestsRecovery;

    private byte[] jobData;

    private List<QrtzTriggers> qrtzTriggersList;

    public QrtzJobDetails() {
    }

    public QrtzJobDetails(String schedName, String jobName, String jobGroup, String description, String jobClassName, String isDurable, String isNonconcurrent, String isUpdateData, String requestsRecovery, byte[] jobData) {
        this.schedName = schedName;
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.description = description;
        this.jobClassName = jobClassName;
        this.isDurable = isDurable;
        this.isNonconcurrent = isNonconcurrent;
        this.isUpdateData = isUpdateData;
        this.requestsRecovery = requestsRecovery;
        this.jobData = jobData;
    }

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
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

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getIsDurable() {
        return isDurable;
    }

    public void setIsDurable(String isDurable) {
        this.isDurable = isDurable;
    }

    public String getIsNonconcurrent() {
        return isNonconcurrent;
    }

    public void setIsNonconcurrent(String isNonconcurrent) {
        this.isNonconcurrent = isNonconcurrent;
    }

    public String getIsUpdateData() {
        return isUpdateData;
    }

    public void setIsUpdateData(String isUpdateData) {
        this.isUpdateData = isUpdateData;
    }

    public String getRequestsRecovery() {
        return requestsRecovery;
    }

    public void setRequestsRecovery(String requestsRecovery) {
        this.requestsRecovery = requestsRecovery;
    }

    public byte[] getJobData() {
        return jobData;
    }

    public void setJobData(byte[] jobData) {
        this.jobData = jobData;
    }

    public List<QrtzTriggers> getQrtzTriggersList() {
        return qrtzTriggersList;
    }

    public void setQrtzTriggersList(List<QrtzTriggers> qrtzTriggersList) {
        this.qrtzTriggersList = qrtzTriggersList;
    }

    public static class Builder {

        private QrtzJobDetails instance = new QrtzJobDetails();

        public Builder schedName(String schedName) {
            instance.setSchedName(schedName);
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

        public Builder jobClassName(String jobClassName) {
            instance.setJobClassName(jobClassName);
            return this;
        }

        public Builder isDurable(String isDurable) {
            instance.setIsDurable(isDurable);
            return this;
        }

        public Builder isNonconcurrent(String isNonconcurrent) {
            instance.setIsNonconcurrent(isNonconcurrent);
            return this;
        }

        public Builder isUpdateData(String isUpdateData) {
            instance.setIsUpdateData(isUpdateData);
            return this;
        }

        public Builder requestsRecovery(String requestsRecovery) {
            instance.setRequestsRecovery(requestsRecovery);
            return this;
        }

        public Builder jobData(byte[] jobData) {
            instance.setJobData(jobData);
            return this;
        }

        public Builder qrtzTriggersList(List<QrtzTriggers> qrtzTriggersList) {
            instance.setQrtzTriggersList(qrtzTriggersList);
            return this;
        }

        public QrtzJobDetails build() {
            return instance;
        }
    }
}
