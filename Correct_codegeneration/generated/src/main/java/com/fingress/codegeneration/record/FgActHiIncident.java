package com.bsit.codegeneration.record;

public record FgActHiIncident(String ID_, String procDefKey_, String procDefID_, String procInstID_, String executionID_, String createTime_, String endTime_, String incidentMsg_, String incidentType_, String activityID_, String causeIncidentID_, String rootCauseIncidentID_, String configuration_, Long incidentState_, String tenantID_, String jobDefID_, String rootProcInstID_, String removalTime_, String historyConfiguration_, String failedActivityID_) {

    public static class Builder {

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

        private Long incidentState_;

        private String tenantID_;

        private String jobDefID_;

        private String rootProcInstID_;

        private String removalTime_;

        private String historyConfiguration_;

        private String failedActivityID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder procDefKey_(String procDefKey_) {
            this.procDefKey_ = procDefKey_;
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            this.procDefID_ = procDefID_;
            return this;
        }

        public Builder procInstID_(String procInstID_) {
            this.procInstID_ = procInstID_;
            return this;
        }

        public Builder executionID_(String executionID_) {
            this.executionID_ = executionID_;
            return this;
        }

        public Builder createTime_(String createTime_) {
            this.createTime_ = createTime_;
            return this;
        }

        public Builder endTime_(String endTime_) {
            this.endTime_ = endTime_;
            return this;
        }

        public Builder incidentMsg_(String incidentMsg_) {
            this.incidentMsg_ = incidentMsg_;
            return this;
        }

        public Builder incidentType_(String incidentType_) {
            this.incidentType_ = incidentType_;
            return this;
        }

        public Builder activityID_(String activityID_) {
            this.activityID_ = activityID_;
            return this;
        }

        public Builder causeIncidentID_(String causeIncidentID_) {
            this.causeIncidentID_ = causeIncidentID_;
            return this;
        }

        public Builder rootCauseIncidentID_(String rootCauseIncidentID_) {
            this.rootCauseIncidentID_ = rootCauseIncidentID_;
            return this;
        }

        public Builder configuration_(String configuration_) {
            this.configuration_ = configuration_;
            return this;
        }

        public Builder incidentState_(Long incidentState_) {
            this.incidentState_ = incidentState_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public Builder jobDefID_(String jobDefID_) {
            this.jobDefID_ = jobDefID_;
            return this;
        }

        public Builder rootProcInstID_(String rootProcInstID_) {
            this.rootProcInstID_ = rootProcInstID_;
            return this;
        }

        public Builder removalTime_(String removalTime_) {
            this.removalTime_ = removalTime_;
            return this;
        }

        public Builder historyConfiguration_(String historyConfiguration_) {
            this.historyConfiguration_ = historyConfiguration_;
            return this;
        }

        public Builder failedActivityID_(String failedActivityID_) {
            this.failedActivityID_ = failedActivityID_;
            return this;
        }

        public FgActHiIncident build() {
            return new FgActHiIncident(ID_, procDefKey_, procDefID_, procInstID_, executionID_, createTime_, endTime_, incidentMsg_, incidentType_, activityID_, causeIncidentID_, rootCauseIncidentID_, configuration_, incidentState_, tenantID_, jobDefID_, rootProcInstID_, removalTime_, historyConfiguration_, failedActivityID_);
        }
    }
}
