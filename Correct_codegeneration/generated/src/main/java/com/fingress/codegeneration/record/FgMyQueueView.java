package com.bsit.codegeneration.record;

public record FgMyQueueView(String ID_, String procInstID_, String name_, String groupID_, String tenantID_, String procDefID_) {

    public static class Builder {

        private String ID_;

        private String procInstID_;

        private String name_;

        private String groupID_;

        private String tenantID_;

        private String procDefID_;

        public Builder ID_(String ID_) {
            this.ID_ = ID_;
            return this;
        }

        public Builder procInstID_(String procInstID_) {
            this.procInstID_ = procInstID_;
            return this;
        }

        public Builder name_(String name_) {
            this.name_ = name_;
            return this;
        }

        public Builder groupID_(String groupID_) {
            this.groupID_ = groupID_;
            return this;
        }

        public Builder tenantID_(String tenantID_) {
            this.tenantID_ = tenantID_;
            return this;
        }

        public Builder procDefID_(String procDefID_) {
            this.procDefID_ = procDefID_;
            return this;
        }

        public FgMyQueueView build() {
            return new FgMyQueueView(ID_, procInstID_, name_, groupID_, tenantID_, procDefID_);
        }
    }
}
