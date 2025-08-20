package com.bsit.codegeneration.record;

public record FgActHiIdentitylink(String ID_, String timestamp_, String type_, String userID_, String groupID_, String taskID_, String procDefID_, String operationType_, String assignerID_, String procDefKey_, String tenantID_, String rootProcInstID_, String removalTime_) {

    public static class Builder {

        private String ID_;

        private String timestamp_;

        private String type_;

        private String userID_;

        private String groupID_;

        private String taskID_;

        private String procDefID_;

        private String operationType_;

        private String assignerID_;

        private String procDefKey_;

        private String tenantID_;

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

        public Builder type_(String type_) {
            this.type_ = type_;
            return this;
        }

        public Builder userID_(String userID_) {
            this.userID_ = userID_;
            return this;
        }

        public Builder groupID_(String groupID_) {
            this.groupID_ = groupID_;
            return this;
        }

        public Builder taskID_(String taskID_) {
            this.taskID_ = taskID_;
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            this.procDefID_ = procDefID_;
            return this;
        }

        public Builder operationType_(String operationType_) {
            this.operationType_ = operationType_;
            return this;
        }

        public Builder assignerID_(String assignerID_) {
            this.assignerID_ = assignerID_;
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

        public Builder rootProcInstID_(String rootProcInstID_) {
            this.rootProcInstID_ = rootProcInstID_;
            return this;
        }

        public Builder removalTime_(String removalTime_) {
            this.removalTime_ = removalTime_;
            return this;
        }

        public FgActHiIdentitylink build() {
            return new FgActHiIdentitylink(ID_, timestamp_, type_, userID_, groupID_, taskID_, procDefID_, operationType_, assignerID_, procDefKey_, tenantID_, rootProcInstID_, removalTime_);
        }
    }
}
