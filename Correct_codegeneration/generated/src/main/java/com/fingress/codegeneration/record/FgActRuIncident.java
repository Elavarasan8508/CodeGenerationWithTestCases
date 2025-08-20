package com.bsit.codegeneration.record;

public record FgActRuIncident(String ID_, Long rev_, String incidentTimestamp_, String incidentMsg_, String incidentType_, String executionID_, String activityID_, String procInstID_, String procDefID_, String causeIncidentID_, String rootCauseIncidentID_, String configuration_, String tenantID_, String jobDefID_, String failedActivityID_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

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

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder incidentTimestamp_(String incidentTimestamp_) {
            this.incidentTimestamp_ = incidentTimestamp_;
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

        public Builder executionID_(String executionID_) {
            this.executionID_ = executionID_;
            return this;
        }

        public Builder activityID_(String activityID_) {
            this.activityID_ = activityID_;
            return this;
        }

        public Builder procInstID_(String procInstID_) {
            this.procInstID_ = procInstID_;
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            this.procDefID_ = procDefID_;
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

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public Builder jobDefID_(String jobDefID_) {
            this.jobDefID_ = jobDefID_;
            return this;
        }

        public Builder failedActivityID_(String failedActivityID_) {
            this.failedActivityID_ = failedActivityID_;
            return this;
        }

        public FgActRuIncident build() {
            return new FgActRuIncident(ID_, rev_, incidentTimestamp_, incidentMsg_, incidentType_, executionID_, activityID_, procInstID_, procDefID_, causeIncidentID_, rootCauseIncidentID_, configuration_, tenantID_, jobDefID_, failedActivityID_);
        }
    }
}
