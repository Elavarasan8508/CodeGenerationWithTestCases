package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;

public class FgActHiIncident {

    private String ID_;

    private String procDefKey_;

    private String procDefID_;

    private String procInstID_;

    private String executionID_;

    private String createTime_;

    private String endTime_;

    private String incidentMsg_;

    private String incidentType_;

    private String activityID_;

    private String causeIncidentID_;

    private String rootCauseIncidentID_;

    private String configuration_;

    private java.math.BigDecimal incidentState_;

    private String tenantID_;

    private String jobDefID_;

    private String rootProcInstID_;

    private String removalTime_;

    private String historyConfiguration_;

    private String failedActivityID_;

    public FgActHiIncident() {
    }

    public FgActHiIncident(String ID_, String procDefKey_, String procDefID_, String procInstID_, String executionID_, String createTime_, String endTime_, String incidentMsg_, String incidentType_, String activityID_, String causeIncidentID_, String rootCauseIncidentID_, String configuration_, java.math.BigDecimal incidentState_, String tenantID_, String jobDefID_, String rootProcInstID_, String removalTime_, String historyConfiguration_, String failedActivityID_) {
        this.ID_ = ID_;
        this.procDefKey_ = procDefKey_;
        this.procDefID_ = procDefID_;
        this.procInstID_ = procInstID_;
        this.executionID_ = executionID_;
        this.createTime_ = createTime_;
        this.endTime_ = endTime_;
        this.incidentMsg_ = incidentMsg_;
        this.incidentType_ = incidentType_;
        this.activityID_ = activityID_;
        this.causeIncidentID_ = causeIncidentID_;
        this.rootCauseIncidentID_ = rootCauseIncidentID_;
        this.configuration_ = configuration_;
        this.incidentState_ = incidentState_;
        this.tenantID_ = tenantID_;
        this.jobDefID_ = jobDefID_;
        this.rootProcInstID_ = rootProcInstID_;
        this.removalTime_ = removalTime_;
        this.historyConfiguration_ = historyConfiguration_;
        this.failedActivityID_ = failedActivityID_;
    }

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public String getProcDefKey_() {
        return procDefKey_;
    }

    public void setProcDefKey_(String procDefKey_) {
        this.procDefKey_ = procDefKey_;
    }

    public String getProcDefID_() {
        return procDefID_;
    }

    public void setProcDefID_(String procDefID_) {
        this.procDefID_ = procDefID_;
    }

    public String getProcInstID_() {
        return procInstID_;
    }

    public void setProcInstID_(String procInstID_) {
        this.procInstID_ = procInstID_;
    }

    public String getExecutionID_() {
        return executionID_;
    }

    public void setExecutionID_(String executionID_) {
        this.executionID_ = executionID_;
    }

    public String getCreateTime_() {
        return createTime_;
    }

    public void setCreateTime_(String createTime_) {
        this.createTime_ = createTime_;
    }

    public String getEndTime_() {
        return endTime_;
    }

    public void setEndTime_(String endTime_) {
        this.endTime_ = endTime_;
    }

    public String getIncidentMsg_() {
        return incidentMsg_;
    }

    public void setIncidentMsg_(String incidentMsg_) {
        this.incidentMsg_ = incidentMsg_;
    }

    public String getIncidentType_() {
        return incidentType_;
    }

    public void setIncidentType_(String incidentType_) {
        this.incidentType_ = incidentType_;
    }

    public String getActivityID_() {
        return activityID_;
    }

    public void setActivityID_(String activityID_) {
        this.activityID_ = activityID_;
    }

    public String getCauseIncidentID_() {
        return causeIncidentID_;
    }

    public void setCauseIncidentID_(String causeIncidentID_) {
        this.causeIncidentID_ = causeIncidentID_;
    }

    public String getRootCauseIncidentID_() {
        return rootCauseIncidentID_;
    }

    public void setRootCauseIncidentID_(String rootCauseIncidentID_) {
        this.rootCauseIncidentID_ = rootCauseIncidentID_;
    }

    public String getConfiguration_() {
        return configuration_;
    }

    public void setConfiguration_(String configuration_) {
        this.configuration_ = configuration_;
    }

    public java.math.BigDecimal getIncidentState_() {
        return incidentState_;
    }

    public void setIncidentState_(java.math.BigDecimal incidentState_) {
        this.incidentState_ = incidentState_;
    }

    public String getTenantID_() {
        return tenantID_;
    }

    public void setTenantID_(String tenantID_) {
        this.tenantID_ = tenantID_;
    }

    public String getJobDefID_() {
        return jobDefID_;
    }

    public void setJobDefID_(String jobDefID_) {
        this.jobDefID_ = jobDefID_;
    }

    public String getRootProcInstID_() {
        return rootProcInstID_;
    }

    public void setRootProcInstID_(String rootProcInstID_) {
        this.rootProcInstID_ = rootProcInstID_;
    }

    public String getRemovalTime_() {
        return removalTime_;
    }

    public void setRemovalTime_(String removalTime_) {
        this.removalTime_ = removalTime_;
    }

    public String getHistoryConfiguration_() {
        return historyConfiguration_;
    }

    public void setHistoryConfiguration_(String historyConfiguration_) {
        this.historyConfiguration_ = historyConfiguration_;
    }

    public String getFailedActivityID_() {
        return failedActivityID_;
    }

    public void setFailedActivityID_(String failedActivityID_) {
        this.failedActivityID_ = failedActivityID_;
    }

    public static class Builder {

        private FgActHiIncident instance = new FgActHiIncident();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder procDefKey_(String procDefKey_) {
            instance.setProcDefKey_(procDefKey_);
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            instance.setProcDefID_(procDefID_);
            return this;
        }

        public Builder procInstID_(String procInstID_) {
            instance.setProcInstID_(procInstID_);
            return this;
        }

        public Builder executionID_(String executionID_) {
            instance.setExecutionID_(executionID_);
            return this;
        }

        public Builder createTime_(String createTime_) {
            instance.setCreateTime_(createTime_);
            return this;
        }

        public Builder endTime_(String endTime_) {
            instance.setEndTime_(endTime_);
            return this;
        }

        public Builder incidentMsg_(String incidentMsg_) {
            instance.setIncidentMsg_(incidentMsg_);
            return this;
        }

        public Builder incidentType_(String incidentType_) {
            instance.setIncidentType_(incidentType_);
            return this;
        }

        public Builder activityID_(String activityID_) {
            instance.setActivityID_(activityID_);
            return this;
        }

        public Builder causeIncidentID_(String causeIncidentID_) {
            instance.setCauseIncidentID_(causeIncidentID_);
            return this;
        }

        public Builder rootCauseIncidentID_(String rootCauseIncidentID_) {
            instance.setRootCauseIncidentID_(rootCauseIncidentID_);
            return this;
        }

        public Builder configuration_(String configuration_) {
            instance.setConfiguration_(configuration_);
            return this;
        }

        public Builder incidentState_(java.math.BigDecimal incidentState_) {
            instance.setIncidentState_(incidentState_);
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public Builder jobDefID_(String jobDefID_) {
            instance.setJobDefID_(jobDefID_);
            return this;
        }

        public Builder rootProcInstID_(String rootProcInstID_) {
            instance.setRootProcInstID_(rootProcInstID_);
            return this;
        }

        public Builder removalTime_(String removalTime_) {
            instance.setRemovalTime_(removalTime_);
            return this;
        }

        public Builder historyConfiguration_(String historyConfiguration_) {
            instance.setHistoryConfiguration_(historyConfiguration_);
            return this;
        }

        public Builder failedActivityID_(String failedActivityID_) {
            instance.setFailedActivityID_(failedActivityID_);
            return this;
        }

        public FgActHiIncident build() {
            return instance;
        }
    }
}
