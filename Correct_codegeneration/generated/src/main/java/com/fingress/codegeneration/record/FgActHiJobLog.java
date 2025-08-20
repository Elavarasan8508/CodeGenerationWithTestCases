package com.bsit.codegeneration.record;

public record FgActHiJobLog(String ID_, String timestamp_, String jobID_, String jobDuedate_, Long jobRetries_, Long jobPriority_, String jobExceptionMsg_, String jobExceptionStackID_, Long jobState_, String jobDefID_, String jobDefType_, String jobDefConfiguration_, String actID_, String executionID_, String processInstanceID_, String processDefID_, String processDefKey_, String deploymentID_, Long sequenceCounter_, String tenantID_, String rootProcInstID_, String removalTime_, String hostname_, String failedActID_) {

    public static class Builder {

        private String ID_;

        private String timestamp_;

        private String jobID_;

        private String jobDuedate_;

        private Long jobRetries_;

        private Long jobPriority_;

        private String jobExceptionMsg_;

        private String jobExceptionStackID_;

        private Long jobState_;

        private String jobDefID_;

        private String jobDefType_;

        private String jobDefConfiguration_;

        private String actID_;

        private String executionID_;

        private String processInstanceID_;

        private String processDefID_;

        private String processDefKey_;

        private String deploymentID_;

        private Long sequenceCounter_;

        private String tenantID_;

        private String rootProcInstID_;

        private String removalTime_;

        private String hostname_;

        private String failedActID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder timestamp_(String timestamp_) {
            this.timestamp_ = timestamp_;
            return this;
        }

        public Builder jobID_(String jobID_) {
            this.jobID_ = jobID_;
            return this;
        }

        public Builder jobDuedate_(String jobDuedate_) {
            this.jobDuedate_ = jobDuedate_;
            return this;
        }

        public Builder jobRetries_(Long jobRetries_) {
            this.jobRetries_ = jobRetries_;
            return this;
        }

        public Builder jobPriority_(Long jobPriority_) {
            this.jobPriority_ = jobPriority_;
            return this;
        }

        public Builder jobExceptionMsg_(String jobExceptionMsg_) {
            this.jobExceptionMsg_ = jobExceptionMsg_;
            return this;
        }

        public Builder jobExceptionStackID_(String jobExceptionStackID_) {
            this.jobExceptionStackID_ = jobExceptionStackID_;
            return this;
        }

        public Builder jobState_(Long jobState_) {
            this.jobState_ = jobState_;
            return this;
        }

        public Builder jobDefID_(String jobDefID_) {
            this.jobDefID_ = jobDefID_;
            return this;
        }

        public Builder jobDefType_(String jobDefType_) {
            this.jobDefType_ = jobDefType_;
            return this;
        }

        public Builder jobDefConfiguration_(String jobDefConfiguration_) {
            this.jobDefConfiguration_ = jobDefConfiguration_;
            return this;
        }

        public Builder actID_(String actID_) {
            this.actID_ = actID_;
            return this;
        }

        public Builder executionID_(String executionID_) {
            this.executionID_ = executionID_;
            return this;
        }

        public Builder processInstanceID_(String processInstanceID_) {
            this.processInstanceID_ = processInstanceID_;
            return this;
        }

        public Builder processDefID_(String processDefID_) {
            this.processDefID_ = processDefID_;
            return this;
        }

        public Builder processDefKey_(String processDefKey_) {
            this.processDefKey_ = processDefKey_;
            return this;
        }

        public Builder deploymentID_(String deploymentID_) {
            this.deploymentID_ = deploymentID_;
            return this;
        }

        public Builder sequenceCounter_(Long sequenceCounter_) {
            this.sequenceCounter_ = sequenceCounter_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
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

        public Builder hostname_(String hostname_) {
            this.hostname_ = hostname_;
            return this;
        }

        public Builder failedActID_(String failedActID_) {
            this.failedActID_ = failedActID_;
            return this;
        }

        public FgActHiJobLog build() {
            return new FgActHiJobLog(ID_, timestamp_, jobID_, jobDuedate_, jobRetries_, jobPriority_, jobExceptionMsg_, jobExceptionStackID_, jobState_, jobDefID_, jobDefType_, jobDefConfiguration_, actID_, executionID_, processInstanceID_, processDefID_, processDefKey_, deploymentID_, sequenceCounter_, tenantID_, rootProcInstID_, removalTime_, hostname_, failedActID_);
        }
    }
}
