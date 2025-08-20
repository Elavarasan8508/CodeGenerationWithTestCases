package com.bsit.codegeneration.record;

public record FgActRuIdentitylink(String ID_, Long rev_, String groupID_, String type_, String userID_, String taskID_, String procDefID_, String tenantID_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String groupID_;

        private String type_;

        private String userID_;

        private String taskID_;

        private String procDefID_;

        private String tenantID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder groupID_(String groupID_) {
            this.groupID_ = groupID_;
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

        public Builder taskID_(String taskID_) {
            this.taskID_ = taskID_;
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            this.procDefID_ = procDefID_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public FgActRuIdentitylink build() {
            return new FgActRuIdentitylink(ID_, rev_, groupID_, type_, userID_, taskID_, procDefID_, tenantID_);
        }
    }
}
