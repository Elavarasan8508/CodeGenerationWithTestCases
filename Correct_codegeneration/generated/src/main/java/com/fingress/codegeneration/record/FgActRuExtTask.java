package com.bsit.codegeneration.record;

public record FgActRuExtTask(String ID_, Long rev_, String workerID_, String topicName_, Long retries_, String errorMsg_, String errorDetailsID_, String lockExpTime_, Long suspensionState_, String executionID_, String procInstID_, String procDefID_, String procDefKey_, String actID_, String actInstID_, String tenantID_, Long priority_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String workerID_;

        private String topicName_;

        private Long retries_;

        private String errorMsg_;

        private String errorDetailsID_;

        private String lockExpTime_;

        private Long suspensionState_;

        private String executionID_;

        private String procInstID_;

        private String procDefID_;

        private String procDefKey_;

        private String actID_;

        private String actInstID_;

        private String tenantID_;

        private Long priority_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder workerID_(String workerID_) {
            this.workerID_ = workerID_;
            return this;
        }

        public Builder topicName_(String topicName_) {
            this.topicName_ = topicName_;
            return this;
        }

        public Builder retries_(Long retries_) {
            this.retries_ = retries_;
            return this;
        }

        public Builder errorMsg_(String errorMsg_) {
            this.errorMsg_ = errorMsg_;
            return this;
        }

        public Builder errorDetailsID_(String errorDetailsID_) {
            this.errorDetailsID_ = errorDetailsID_;
            return this;
        }

        public Builder lockExpTime_(String lockExpTime_) {
            this.lockExpTime_ = lockExpTime_;
            return this;
        }

        public Builder suspensionState_(Long suspensionState_) {
            this.suspensionState_ = suspensionState_;
            return this;
        }

        public Builder executionID_(String executionID_) {
            this.executionID_ = executionID_;
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

        public Builder procDefKey_(String procDefKey_) {
            this.procDefKey_ = procDefKey_;
            return this;
        }

        public Builder actID_(String actID_) {
            this.actID_ = actID_;
            return this;
        }

        public Builder actInstID_(String actInstID_) {
            this.actInstID_ = actInstID_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public Builder priority_(Long priority_) {
            this.priority_ = priority_;
            return this;
        }

        public FgActRuExtTask build() {
            return new FgActRuExtTask(ID_, rev_, workerID_, topicName_, retries_, errorMsg_, errorDetailsID_, lockExpTime_, suspensionState_, executionID_, procInstID_, procDefID_, procDefKey_, actID_, actInstID_, tenantID_, priority_);
        }
    }
}
