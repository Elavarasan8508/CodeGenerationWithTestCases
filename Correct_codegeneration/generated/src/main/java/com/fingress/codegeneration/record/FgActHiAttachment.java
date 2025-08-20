package com.bsit.codegeneration.record;

public record FgActHiAttachment(String ID_, Long rev_, String userID_, String name_, String description_, String type_, String taskID_, String procInstID_, String URL_, String contentID_, String tenantID_, String createTime_, String rootProcInstID_, String removalTime_) {

    public static class Builder {

        private String ID_;

        private Long rev_;

        private String userID_;

        private String name_;

        private String description_;

        private String type_;

        private String taskID_;

        private String procInstID_;

        private String URL_;

        private String contentID_;

        private String tenantID_;

        private String createTime_;

        private String rootProcInstID_;

        private String removalTime_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder rev_(Long rev_) {
            this.rev_ = rev_;
            return this;
        }

        public Builder userID_(String userID_) {
            this.userID_ = userID_;
            return this;
        }

        public Builder name_(String name_) {
            this.name_ = name_;
            return this;
        }

        public Builder description_(String description_) {
            this.description_ = description_;
            return this;
        }

        public Builder type_(String type_) {
            this.type_ = type_;
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

        public Builder URL_(String URL_) {
            this.URL_ = URL_;
            return this;
        }

        public Builder contentID_(String contentID_) {
            this.contentID_ = contentID_;
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

        public Builder rootProcInstID_(String rootProcInstID_) {
            this.rootProcInstID_ = rootProcInstID_;
            return this;
        }

        public Builder removalTime_(String removalTime_) {
            this.removalTime_ = removalTime_;
            return this;
        }

        public FgActHiAttachment build() {
            return new FgActHiAttachment(ID_, rev_, userID_, name_, description_, type_, taskID_, procInstID_, URL_, contentID_, tenantID_, createTime_, rootProcInstID_, removalTime_);
        }
    }
}
