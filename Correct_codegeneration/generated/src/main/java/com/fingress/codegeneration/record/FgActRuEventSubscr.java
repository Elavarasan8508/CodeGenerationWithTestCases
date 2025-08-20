package com.bsit.codegeneration.record;

public record FgActRuEventSubscr(String ID_, Long rev_, String eventType_, String eventName_, String executionID_, String procInstID_, String activityID_, String configuration_, String created_, String tenantID_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String eventType_;

        private String eventName_;

        private String executionID_;

        private String procInstID_;

        private String activityID_;

        private String configuration_;

        private String created_;

        private String tenantID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder eventType_(String eventType_) {
            this.eventType_ = eventType_;
            return this;
        }

        public Builder eventName_(String eventName_) {
            this.eventName_ = eventName_;
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

        public Builder activityID_(String activityID_) {
            this.activityID_ = activityID_;
            return this;
        }

        public Builder configuration_(String configuration_) {
            this.configuration_ = configuration_;
            return this;
        }

        public Builder created_(String created_) {
            this.created_ = created_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public FgActRuEventSubscr build() {
            return new FgActRuEventSubscr(ID_, rev_, eventType_, eventName_, executionID_, procInstID_, activityID_, configuration_, created_, tenantID_);
        }
    }
}
