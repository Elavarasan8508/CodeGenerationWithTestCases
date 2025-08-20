package com.bsit.codegeneration.record;

public record FgActHiExtTaskLog(String ID_, String timestamp_, String extTaskID_, Long retries_, String topicName_, String workerID_, Long priority_, String errorMsg_, String errorDetailsID_, String actID_, String actInstID_, String executionID_, String procInstID_, String procDefID_, String procDefKey_, String tenantID_, Long state_, String rootProcInstID_, String removalTime_) {

    public static class Builder {

        private String ID_;

        private String timestamp_;

        private String extTaskID_;

        private Long retries_;

        private String topicName_;

        private String workerID_;

        private Long priority_;

        private String errorMsg_;

        private String errorDetailsID_;

        private String actID_;

        private String actInstID_;

        private String executionID_;

        private String procInstID_;

        private String procDefID_;

        private String procDefKey_;

        private String tenantID_;

        private Long state_;

        private String rootProcInstID_;

        private String removalTime_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder timestamp_(String timestamp_) {
            this.timestamp_ = timestamp_;
            return this;
        }

        public Builder extTaskID_(String extTaskID_) {
            this.extTaskID_ = extTaskID_;
            return this;
        }

        public Builder retries_(Long retries_) {
            this.retries_ = retries_;
            return this;
        }

        public Builder topicName_(String topicName_) {
            this.topicName_ = topicName_;
            return this;
        }

        public Builder workerID_(String workerID_) {
            this.workerID_ = workerID_;
            return this;
        }

        public Builder priority_(Long priority_) {
            this.priority_ = priority_;
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

        public Builder actID_(String actID_) {
            this.actID_ = actID_;
            return this;
        }

        public Builder actInstID_(String actInstID_) {
            this.actInstID_ = actInstID_;
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

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public Builder state_(Long state_) {
            this.state_ = state_;
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

        public FgActHiExtTaskLog build() {
            return new FgActHiExtTaskLog(ID_, timestamp_, extTaskID_, retries_, topicName_, workerID_, priority_, errorMsg_, errorDetailsID_, actID_, actInstID_, executionID_, procInstID_, procDefID_, procDefKey_, tenantID_, state_, rootProcInstID_, removalTime_);
        }
    }
}
