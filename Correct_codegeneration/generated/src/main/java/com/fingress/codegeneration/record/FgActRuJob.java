package com.bsit.codegeneration.record;

public record FgActRuJob(String ID_, Long rev_, String type_, String lockExpTime_, String lockOwner_, Long exclusive_, String executionID_, String processInstanceID_, String processDefID_, String processDefKey_, Long retries_, String exceptionStackID_, String exceptionMsg_, String duedate_, String repeat_, String handlerType_, String handlerCfg_, String deploymentID_, Long suspensionState_, String jobDefID_, Long priority_, Long sequenceCounter_, String tenantID_, String createTime_, Long repeatOffset_, String failedActID_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String type_;

        private String lockExpTime_;

        private String lockOwner_;

        private Long exclusive_;

        private String executionID_;

        private String processInstanceID_;

        private String processDefID_;

        private String processDefKey_;

        private Long retries_;

        private String exceptionStackID_;

        private String exceptionMsg_;

        private String duedate_;

        private String repeat_;

        private String handlerType_;

        private String handlerCfg_;

        private String deploymentID_;

        private Long suspensionState_;

        private String jobDefID_;

        private Long priority_;

        private Long sequenceCounter_;

        private String tenantID_;

        private String createTime_;

        private Long repeatOffset_;

        private String failedActID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder type_(String type_) {
            this.type_ = type_;
            return this;
        }

        public Builder lockExpTime_(String lockExpTime_) {
            this.lockExpTime_ = lockExpTime_;
            return this;
        }

        public Builder lockOwner_(String lockOwner_) {
            this.lockOwner_ = lockOwner_;
            return this;
        }

        public Builder exclusive_(Long exclusive_) {
            this.exclusive_ = exclusive_;
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

        public Builder retries_(Long retries_) {
            this.retries_ = retries_;
            return this;
        }

        public Builder exceptionStackID_(String exceptionStackID_) {
            this.exceptionStackID_ = exceptionStackID_;
            return this;
        }

        public Builder exceptionMsg_(String exceptionMsg_) {
            this.exceptionMsg_ = exceptionMsg_;
            return this;
        }

        public Builder duedate_(String duedate_) {
            this.duedate_ = duedate_;
            return this;
        }

        public Builder repeat_(String repeat_) {
            this.repeat_ = repeat_;
            return this;
        }

        public Builder handlerType_(String handlerType_) {
            this.handlerType_ = handlerType_;
            return this;
        }

        public Builder handlerCfg_(String handlerCfg_) {
            this.handlerCfg_ = handlerCfg_;
            return this;
        }

        public Builder deploymentID_(String deploymentID_) {
            this.deploymentID_ = deploymentID_;
            return this;
        }

        public Builder suspensionState_(Long suspensionState_) {
            this.suspensionState_ = suspensionState_;
            return this;
        }

        public Builder jobDefID_(String jobDefID_) {
            this.jobDefID_ = jobDefID_;
            return this;
        }

        public Builder priority_(Long priority_) {
            this.priority_ = priority_;
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

        public Builder createTime_(String createTime_) {
            this.createTime_ = createTime_;
            return this;
        }

        public Builder repeatOffset_(Long repeatOffset_) {
            this.repeatOffset_ = repeatOffset_;
            return this;
        }

        public Builder failedActID_(String failedActID_) {
            this.failedActID_ = failedActID_;
            return this;
        }

        public FgActRuJob build() {
            return new FgActRuJob(ID_, rev_, type_, lockExpTime_, lockOwner_, exclusive_, executionID_, processInstanceID_, processDefID_, processDefKey_, retries_, exceptionStackID_, exceptionMsg_, duedate_, repeat_, handlerType_, handlerCfg_, deploymentID_, suspensionState_, jobDefID_, priority_, sequenceCounter_, tenantID_, createTime_, repeatOffset_, failedActID_);
        }
    }
}
