package com.bsit.codegeneration.record;

public record FgActHiComment(String ID_, String type_, String time_, String userID_, String taskID_, String procInstID_, String action_, String message_, String fullMsg_, String tenantID_, String rootProcInstID_, String removalTime_) {

    public static class Builder {

        private String ID_;

        private String type_;

        private String time_;

        private String userID_;

        private String taskID_;

        private String procInstID_;

        private String action_;

        private String message_;

        private String fullMsg_;

        private String tenantID_;

        private String rootProcInstID_;

        private String removalTime_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder type_(String type_) {
            this.type_ = type_;
            return this;
        }

        public Builder time_(String time_) {
            this.time_ = time_;
            return this;
        }

        public Builder userID_(String userID_) {
            this.userID_ = userID_;
            return this;
        }

        public Builder taskID_(String taskID_) {
            this.taskID_ = taskID_;
            return this;
        }

        public Builder procInstID_(String procInstID_) {
            this.procInstID_ = procInstID_;
            return this;
        }

        public Builder action_(String action_) {
            this.action_ = action_;
            return this;
        }

        public Builder message_(String message_) {
            this.message_ = message_;
            return this;
        }

        public Builder fullMsg_(String fullMsg_) {
            this.fullMsg_ = fullMsg_;
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

        public FgActHiComment build() {
            return new FgActHiComment(ID_, type_, time_, userID_, taskID_, procInstID_, action_, message_, fullMsg_, tenantID_, rootProcInstID_, removalTime_);
        }
    }
}
