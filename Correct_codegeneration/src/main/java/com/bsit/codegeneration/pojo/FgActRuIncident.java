package com.bsit.codegeneration.pojo;

import java.math.BigDecimal;
import java.util.List;

public class FgActRuIncident {

    private String ID_;

    private java.math.BigDecimal rev_;

    private String incidentTimestamp_;

    private String incidentMsg_;

    private String incidentType_;

    private String executionID_;

    private String activityID_;

    private String procInstID_;

    private String procDefID_;

    private String causeIncidentID_;

    private String rootCauseIncidentID_;

    private String configuration_;

    private String tenantID_;

    private String jobDefID_;

    private String failedActivityID_;

    private List<FgActRuIncident> fgActRuIncidentList;

    public FgActRuIncident() {
    }

    public FgActRuIncident(String ID_, java.math.BigDecimal rev_, String incidentTimestamp_, String incidentMsg_, String incidentType_, String executionID_, String activityID_, String procInstID_, String procDefID_, String causeIncidentID_, String rootCauseIncidentID_, String configuration_, String tenantID_, String jobDefID_, String failedActivityID_) {
        this.ID_ = ID_;
        this.rev_ = rev_;
        this.incidentTimestamp_ = incidentTimestamp_;
        this.incidentMsg_ = incidentMsg_;
        this.incidentType_ = incidentType_;
        this.executionID_ = executionID_;
        this.activityID_ = activityID_;
        this.procInstID_ = procInstID_;
        this.procDefID_ = procDefID_;
        this.causeIncidentID_ = causeIncidentID_;
        this.rootCauseIncidentID_ = rootCauseIncidentID_;
        this.configuration_ = configuration_;
        this.tenantID_ = tenantID_;
        this.jobDefID_ = jobDefID_;
        this.failedActivityID_ = failedActivityID_;
    }

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public java.math.BigDecimal getRev_() {
        return rev_;
    }

    public void setRev_(java.math.BigDecimal rev_) {
        this.rev_ = rev_;
    }

    public String getIncidentTimestamp_() {
        return incidentTimestamp_;
    }

    public void setIncidentTimestamp_(String incidentTimestamp_) {
        this.incidentTimestamp_ = incidentTimestamp_;
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

    public String getExecutionID_() {
        return executionID_;
    }

    public void setExecutionID_(String executionID_) {
        this.executionID_ = executionID_;
    }

    public String getActivityID_() {
        return activityID_;
    }

    public void setActivityID_(String activityID_) {
        this.activityID_ = activityID_;
    }

    public String getProcInstID_() {
        return procInstID_;
    }

    public void setProcInstID_(String procInstID_) {
        this.procInstID_ = procInstID_;
    }

    public String getProcDefID_() {
        return procDefID_;
    }

    public void setProcDefID_(String procDefID_) {
        this.procDefID_ = procDefID_;
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

    public String getFailedActivityID_() {
        return failedActivityID_;
    }

    public void setFailedActivityID_(String failedActivityID_) {
        this.failedActivityID_ = failedActivityID_;
    }

    public List<FgActRuIncident> getFgActRuIncidentList() {
        return fgActRuIncidentList;
    }

    public void setFgActRuIncidentList(List<FgActRuIncident> fgActRuIncidentList) {
        this.fgActRuIncidentList = fgActRuIncidentList;
    }

    public static class Builder {

        private FgActRuIncident instance = new FgActRuIncident();

        public Builder ID_(String ID_) {
            instance.setID_(ID_);
            return this;
        }

        public Builder rev_(java.math.BigDecimal rev_) {
            instance.setRev_(rev_);
            return this;
        }

        public Builder incidentTimestamp_(String incidentTimestamp_) {
            instance.setIncidentTimestamp_(incidentTimestamp_);
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

        public Builder executionID_(String executionID_) {
            instance.setExecutionID_(executionID_);
            return this;
        }

        public Builder activityID_(String activityID_) {
            instance.setActivityID_(activityID_);
            return this;
        }

        public Builder procInstID_(String procInstID_) {
            instance.setProcInstID_(procInstID_);
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            instance.setProcDefID_(procDefID_);
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

        public Builder tenantID_(String tenantID_) {
            instance.setTenantID_(tenantID_);
            return this;
        }

        public Builder jobDefID_(String jobDefID_) {
            instance.setJobDefID_(jobDefID_);
            return this;
        }

        public Builder failedActivityID_(String failedActivityID_) {
            instance.setFailedActivityID_(failedActivityID_);
            return this;
        }

        public Builder fgActRuIncidentList(List<FgActRuIncident> fgActRuIncidentList) {
            instance.setFgActRuIncidentList(fgActRuIncidentList);
            return this;
        }

        public FgActRuIncident build() {
            return instance;
        }
    }
}
